package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gamepage")
public class GamePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("photoOfGame", "/images/homePageImages/CaseOne.jpg");
        req.setAttribute("gameName", "The Last Of Us Part II");
        req.setAttribute("gameRating", 5.00);
        req.setAttribute("gameCompany", "Sony");
        req.setAttribute("gamePrice", "4499");
        req.setAttribute("gameDescription", "Best game ever!!!");
        req.setAttribute("gameID", 123);

        req.getServletContext().getRequestDispatcher("/gamepage.jsp").forward(req, resp);
    }


}

