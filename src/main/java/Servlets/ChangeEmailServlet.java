package Servlets;


import Model.UserServices.User;
import Model.UserServices.UserDB;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/changeEmail")
public class ChangeEmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDB userDd = new UserDB();
        HttpSession session = req.getSession();

        String email = (String) req.getParameter("email");
        String username = (String) session.getAttribute("username");

        User user = userDd.getUserByName(username);
        userDd.changeEmailById(user.getId(), email);

        resp.sendRedirect("/profilepage");
    }
}
