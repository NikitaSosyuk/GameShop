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

@WebServlet("/changeUsername")
public class ChangeUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDB userDd = new UserDB();
        HttpSession session = req.getSession();

        String newUsername = req.getParameter("new-username");
        String oldUsername = (String) session.getAttribute("username");

        User user = userDd.getUserByName(oldUsername);
        userDd.changeUsernameById(user.getId(), newUsername);

        session.setAttribute("username", newUsername);

        resp.sendRedirect("/profilepage");
    }
}
