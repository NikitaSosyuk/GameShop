package Servlets;

import Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/basketpage")
public class BasketPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        product.price = 4500;
        product.count = 2;
        product.name = "The Last Of Us Part II";
        List<Product> products = new LinkedList<>();
        products.add(product);

        req.setAttribute("products", products);
        req.getServletContext().getRequestDispatcher("/basketpage.jsp").forward(req, resp);
    }


}

