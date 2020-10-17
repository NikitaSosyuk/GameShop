package Servlets;

import Model.User;
import Model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profilepage")
public class ProfilePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        UserDB users = new UserDB();
        User user = users.getUserByName(username);

        session.setAttribute("registrationTimestamp", user.getRegistrationTimestamp().toString());
        req.getServletContext().getRequestDispatcher("/profilepage.jsp").forward(req, resp);
    }
}
