package Servlets;

import Model.ProductServices.Product;
import Model.PurchasesServices.PurchasesDB;
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

@WebServlet("/profilepage")
public class ProfilePageServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        UserDB users = new UserDB();
        User user = users.getUserByName(username);
        String registrationTimestamp = user.getRegistrationTimestamp().toString();
        String email = user.getEmail();

        PurchasesDB purchasesDB = new PurchasesDB();
        int purchasesCount = purchasesDB.getCountOfPurchase(username);
        Product lastProduct = purchasesDB.getLastPurchase(username);

        req.setAttribute("purchasesCount", purchasesCount);
        if (lastProduct == null) {
            req.setAttribute("lastProductName", "-");
        } else {
            req.setAttribute("lastProductName", lastProduct.getName());
        }
        req.setAttribute("registrationTimestamp", registrationTimestamp);
        if (email == null) {
            req.setAttribute("email", "-");
        } else {
            req.setAttribute("email", email);
        }

        req.getServletContext().getRequestDispatcher("/profilepage.jsp").forward(req, resp);
    }
}
