package filter;

import javaBack.UserDB;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LogInFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        UserDB db = new UserDB();

        String login = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("remember");

        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("user")) {
                req.setAttribute("username", cookie.getValue());
                req.getRequestDispatcher("./HomePage/homepage.jsp").forward(req, res);
            }
        }

        if (login == null && password == null) {
            req.getRequestDispatcher("./LogIn/login.html").forward(req, res);
        } else {
            if (db.userIsExist(login, password)) {
                if (cookieCheck != null && cookieCheck.equals("check")) {
                    Cookie cookie = new Cookie("user", login);
                    cookie.setMaxAge(60);
                    res.addCookie(cookie);
                }
                req.setAttribute("username", login);
                req.getRequestDispatcher("./HomePage/homepage.jsp").forward(req, res);
            } else {
                req.getRequestDispatcher("./LogIn/login.html").forward(req, res);
            }
        }
    }

}