package controller;

import dao.LoginDao;
import model.Accountdemo;
import model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns ="/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/loginproduct.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        Users user = LoginDao.login(userName, passWord);
        if (!Objects.isNull(user)) {
            if (user.getIdRole() == 1) {
                resp.sendRedirect("/Product");
            } else {
                resp.sendRedirect("/product-list");
            }
        } else {
            resp.sendRedirect("/loginproduct.jsp");
        }
    }
}
