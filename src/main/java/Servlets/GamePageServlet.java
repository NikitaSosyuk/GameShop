package Servlets;

import Model.ProductServices.Product;
import Model.ProductServices.ProductDB;

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
        int id = Integer.parseInt(req.getParameter("id"));
        ProductDB productDB = new ProductDB();
        Product product = productDB.getProductByID(id);
        req.setAttribute("game", product);

        System.out.println(product.toString());

        req.getServletContext().getRequestDispatcher("/gamepage.jsp").forward(req, resp);
    }
}

