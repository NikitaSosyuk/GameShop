package Servlets;

import Model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logInCheck")
public class LoginCheckServlet extends HttpServlet {

    //сам сделай логику с бд
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserDB users = new UserDB();
        resp.setCharacterEncoding("UTF-8");
        if (users.getUserByName(username) == null) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }
}