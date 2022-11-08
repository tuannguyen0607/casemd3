package dao;

import model.Accountdemo;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LoginDao {
    public static Users login(String userName, String passWord) {
        try {

            String sql = "select * from users where userName = ? and passWord = ?";
            Connection connection = Connect_MySql.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2, passWord);
            ResultSet resultSet = preparedStatement.executeQuery();
            //.next la de xuong dong lay hang. chu khong .next se lay cot tieu de
            Users users = null;
            if (resultSet.next()) {
                String userName1 = resultSet.getString("userName");
                String passWord1 = resultSet.getString("passWord");
                String gmail = resultSet.getString("gmail");
                String number = resultSet.getString("number");
                int idRole = resultSet.getInt("idRole");
                users = new Users( userName1, passWord1, gmail, number, idRole);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

