package Servlets;

import Model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("remember");

        HttpSession session = req.getSession();

        UserDB users = new UserDB();

        if(username.equals("") || password.equals("")) {
            req.getServletContext().getRequestDispatcher("/signInPage").forward(req, resp);
        } else {
            if (users.userIsExist(username, password)) {
                resp.sendRedirect("/homepage");
                session.setAttribute("username", username);
            } else {
                resp.sendRedirect("/login");
            }
        }
    }

}
