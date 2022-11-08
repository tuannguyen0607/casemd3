package servletproduct;

import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProducTServlet", value = "/Product")
public class ProducTServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("sanphams", ProductService.products);
        request.setAttribute("Categorys", ProductService.categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showProduct.jsp");
        dispatcher.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
