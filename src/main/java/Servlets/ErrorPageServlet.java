package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/errorpage")
public class ErrorPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("error-id");
        if (x.length() == 3) {
            req.setAttribute("first", x.charAt(0));
            req.setAttribute("second", x.charAt(1));
            req.setAttribute("third", x.charAt(2));
        }
        req.getServletContext().getRequestDispatcher("/errorpage.jsp").forward(req, resp);
    }


}