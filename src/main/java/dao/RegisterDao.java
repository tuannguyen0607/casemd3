package dao;

import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    public static void registerDao(Users user) {
        try {
            String sql = "insert into users (userName,passWord,gmail,number,idRole) values (?,?,?,?,?)";
            Connection connection = Connect_MySql.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassWord());
            preparedStatement.setString(3, user.getGmail());
            preparedStatement.setString(4, user.getNumber());
            preparedStatement.setInt(5, user.getIdRole());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

