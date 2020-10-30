package Servlets;

import Model.UserServices.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet  {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("remember");
        HttpSession session = req.getSession();

        UserDB userDB = new UserDB();
        if (userDB.userIsExist(username, password)) {
            resp.sendRedirect("/registration");
        } else {
            if (userDB.saveUser(username, password)) {
                if (cookieCheck != null && cookieCheck.equals("check")) {
                    Cookie cookie = new Cookie("saved", username);
                    cookie.setMaxAge(100);
                    resp.addCookie(cookie);
                }
                resp.sendRedirect("/homepage");
                session.setAttribute("username", username);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.html").forward(req, resp);
    }

}
