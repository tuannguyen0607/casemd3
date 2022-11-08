package controller;

import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_product = Integer.parseInt(req.getParameter("id"));
        ProductService.delete(id_product);
        RequestDispatcher dispatcher =req.getRequestDispatcher("/Product");
        dispatcher.forward(req,resp);
    }
}
