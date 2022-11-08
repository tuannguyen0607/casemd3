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
import java.util.ArrayList;
import java.util.List;
@WebServlet("/addCart")
public class AddCart extends HttpServlet {
    public static List<Product> productList = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                int id = Integer.parseInt(req.getParameter("id"));
                for (Product p : ProductService.products) {
                    if (p.getId_product() == id) {
                        productList.add(p);
                    }
                }
                break;
            case "delete":
                int idXoa = Integer.parseInt(req.getParameter("id"));
                for (int i = 0; i< productList.size(); i++) {
                    if (productList.get(i).getId_product() == idXoa) {
                        productList.remove(i);
                    }
                }
                break;
        }
        req.setAttribute("sanphams", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(req, resp);


    }

    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            productList.remove(id);
        }
    }
}
