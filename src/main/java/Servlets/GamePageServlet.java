package Servlets;

import Model.Game;

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

        Game game = new Game();
        game.setCompany("Sony");
        game.setDescription("Five years after their dangerous journey across the post-pandemic United States, Ellie and Joel have settled down in Jackson, Wyoming. Living amongst a thriving community of survivors has allowed them peace and stability, despite the constant threat of the infected and other, more desperate survivors. When a violent event disrupts that peace, Ellie embarks on a relentless journey to carry out justice and find closure. As she hunts those responsible one by one, she is confronted with the devastating physical and emotional repercussions of her actions.");
        game.setId(1);
        game.setPrice(4499);
        game.setRating(5.0);
        game.setName("The Last Of Us Part II");
        game.setImage("images/homePageImages/CaseOne.jpg");

        req.setAttribute("game", game);
        req.getServletContext().getRequestDispatcher("/gamepage.jsp").forward(req, resp);
    }


}

