package servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

   @Override
protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

   req.getRequestDispatcher("webapp/WEB-INF/index.jsp").forward(req,resp);


   }
}