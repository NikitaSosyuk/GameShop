package Servlets;

import Model.UserServices.User;
import Model.UserServices.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editpage")
public class EditPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        UserDB userDB = new UserDB();
        User user = userDB.getUserByName(username);

        req.getServletContext().getRequestDispatcher("/editpage.jsp").forward(req, resp);
    }
}