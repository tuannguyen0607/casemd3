package servletproduct;

import dao.CRUD_Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductCategoryServlet", value = "/ProductCategoryServlet")
public class ProductCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idcategory"));
        request.setAttribute("sanphams", CRUD_Product.getByIdCategory(id));
        request.setAttribute("Categorys", ProductService.categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/shop.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
