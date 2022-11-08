package controller;

import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_product = Integer.parseInt(req.getParameter("id"));
        for (Product p: ProductService.products)
        { if (p.getId_product() == id_product) {
         req.setAttribute("p",p);
          }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editproduct.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_product = Integer.parseInt(req.getParameter("id_product"));
        String nameproduct =req.getParameter("nameproduct");
        String img = req.getParameter("img");
        double price = Double.parseDouble(req.getParameter("price"));
        int amountTotal = Integer.parseInt(req.getParameter("amountTotal"));
        String detail = req.getParameter("detail");
        ProductService.edit(id_product, new Product(id_product,nameproduct,img,price,amountTotal,detail));
        resp.sendRedirect("/Product");
    }
}
