package servlet;

import dto.Order;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="createOrder", value = "/orderDetails")
public class CreateOrder extends HttpServlet {
    public static List<Order> orders = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/webapp/WEB-INF/orders.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = Order.builder()
                .lipstick(req.getParameter("lipstick"))
                .shampoo(req.getParameter("shampoo"))
                .gel(req.getParameter("gel"))
                .soap(req.getParameter("soap"))
                .mascara(req.getParameter("mascara"))
                .build();
        orders.add(order);
        req.setAttribute("lipstick", order.getLipstick());
        req.setAttribute("shampoo", order.getShampoo());
        req.setAttribute("gel", order.getGel());
        req.setAttribute("soap", order.getSoap());
        req.setAttribute("mascara", order.getMascara());
        req.getRequestDispatcher("webapp/WEB-INF/orderDetails.jsp").forward(req, resp);
    }
}
