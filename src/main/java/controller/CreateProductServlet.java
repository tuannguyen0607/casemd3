package controller;

import model.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/create")
public class CreateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_product = Integer.parseInt(req.getParameter("id"));
        String nameproduct = req.getParameter("name");
        String img = req.getParameter("img");
        double price = Double.parseDouble(req.getParameter("price"));
        int amountTotal = Integer.parseInt(req.getParameter("amountTotal"));
        String detail =req.getParameter("detail");
        ProductService.add(new Product(id_product,nameproduct,img,price,amountTotal,detail));
        resp.sendRedirect("/Product");
    }
}
