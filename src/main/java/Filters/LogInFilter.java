package Filters;

import Model.UserServices.UserDB;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/*"})
public class LogInFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        UserDB db = new UserDB();

        String login = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("remember");
        HttpSession session =  req.getSession();

        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("user")) {
                session.setAttribute("username", cookie.getValue());
                res.sendRedirect("/homepage");
            }
        }

        if (login == null && password == null) {
            res.sendRedirect("/login");
        } else {
            if (db.userIsExist(login, password)) {
                if (cookieCheck != null && cookieCheck.equals("check")) {
                    Cookie cookie = new Cookie("user", login);
                    cookie.setMaxAge(10);
                    res.addCookie(cookie);
                }
                session.setAttribute("username", login);
                res.sendRedirect("/homepage");
            } else {
                res.sendRedirect("/login");
            }
        }
    }

}
