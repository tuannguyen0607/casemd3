package controller;

import dao.RegisterDao;
import model.Users;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/Register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        if (UserService.checkUser(userName)
        ) {
            req.setAttribute("messusername", " user Name da ton tai");
        }
        if (userName.equals("")) {
            req.setAttribute("messusername", "user name khong de trong");
        }

        String passWord = req.getParameter("passWord");
        Pattern pattern1 = Pattern.compile(" /^[A-Za-z0-9_\\.]{6,32}$/");
        if (!pattern1.matcher(passWord).find()) {
            req.setAttribute("messpassword", "Tối thiểu tám ký tự, ít nhất một chữ cái và một số");
        }

        String ConfirmPassword = req.getParameter("ConfirmPassword");
        if (!ConfirmPassword.equals(passWord)) {
            req.setAttribute("messconfirm", "xác nhận sai mật khẩu");
        }

        String gmail = req.getParameter("gmail");
        Pattern pattern2 = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        boolean checkGmail = UserService.checkUser(gmail);
        if (!pattern2.matcher(gmail).find()) {
            req.setAttribute("messusername", " gmail da ton tai");
        }
        if (gmail.equals("")) {
            req.setAttribute("messusername", "gmail khong de trong");
        }

        String number = req.getParameter("number");
        Pattern pattern3 = Pattern.compile("^0{1}[1-9]{1}[0-9]{8}$");
        if (!pattern3.matcher(number).find()) {
            req.setAttribute("messnumber", "10 chữ số, vd: 0xxxxxxxxx");
        }
        boolean check1 = passWord.equals(ConfirmPassword);
        boolean check3 = pattern3.matcher(number).find();
        boolean check4 = UserService.checkUser(userName);
        if (check1 && check3 && check4) {
            Users user = new Users();
            user.setUserName(userName);
            user.setPassWord(passWord);
            user.setGmail(gmail);
            user.setNumber(number);
            user.setIdRole(2);
            RegisterDao.registerDao(user);
            resp.sendRedirect("/loginproduct.jsp");
        } else {
            req.setAttribute("mess1", "Lỗi Rồi");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Register.jsp");
            dispatcher.forward(req, resp);

        }

    }
}

