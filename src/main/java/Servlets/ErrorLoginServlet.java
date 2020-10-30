package Servlets;

import Model.UserServices.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/errorlogin")
public class ErrorLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/loginError.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("remember");
        System.out.println("entered");

        HttpSession session = req.getSession();

        UserDB users = new UserDB();

        if(username.equals("") || password.equals("")) {
            resp.sendRedirect("/errorlogin");
            System.out.println("empty");
        } else {
            if (users.userIsExist(username, password)) {
                if (cookieCheck != null && cookieCheck.equals("check")) {
                    Cookie cookie = new Cookie("saved", username);
                    cookie.setMaxAge(100);
                    resp.addCookie(cookie);
                }
                resp.sendRedirect("/homepage");
                session.setAttribute("username", username);
            } else {
                resp.sendRedirect("/errorlogin");
            }
        }
    }
}
