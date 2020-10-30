package Servlets;

import Model.BasketServices.BasketDB;
import Model.ProductServices.Product;
import Model.PurchasesServices.PurchasesDB;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/buypage")
public class BuyPageServlet extends HttpServlet {



    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        PurchasesDB purchasesDB = new PurchasesDB();
        List<Product> products = purchasesDB.getLastPurchaseList(username);
        req.setAttribute("products", products);

        req.getServletContext().getRequestDispatcher("/buypage.jsp").forward(req, resp);
    }

}