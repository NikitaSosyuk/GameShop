package Servlets;

import Model.BasketServices.BasketDB;
import Model.ProductServices.Product;
import Model.ProductServices.ProductDB;
import Model.PurchasesServices.PurchasesDB;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/basketpage")
public class BasketPage extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        BasketDB basketDB = new BasketDB();

        List<Product> products = basketDB.getListOfProductsInBasketByUsername(username);
        req.setAttribute("products", products);

        req.getServletContext().getRequestDispatcher("/basketpage.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        BasketDB basketDB = new BasketDB();
        PurchasesDB purchasesDB = new PurchasesDB();

        List<Product> products = basketDB.getListOfProductsInBasketByUsername(username);
        purchasesDB.insertProductsIntoDB(username, products);
        basketDB.cleanBasketForUser(username);

        resp.sendRedirect("/buypage");
    }
}

