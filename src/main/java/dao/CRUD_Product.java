package dao;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Product {
   public static Connection connection = Connect_MySql.getConnect();
    public static List<Product> getALL() {
        String sql = "select * from product";
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_product = resultSet.getInt("id_product");
                String nameproduct = resultSet.getString("nameproduct");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                int amountTotal = resultSet.getInt("amountTotal");
                String detail = resultSet.getString("detail");
                products.add(new Product(id_product, nameproduct, img, price, amountTotal, detail));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            }return products;
    }
    public static void save(Product product) {
        try {
            String sql = "insert into product value (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getId_product());
            preparedStatement.setString(2, product.getNameproduct());
            preparedStatement.setString(3, product.getImg());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5,product.getAmountTotal());
            preparedStatement.setString(6,product.getDetail());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//
    public static void deleteproduct(int id_product) {
        String deleteSQL = "DELETE from product where id_product=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1,id_product);
            preparedStatement.execute();
//
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void editproduct(int id_product, Product product) {
        String editsql = "UPDATE product SET nameproduct=? , img=? , price=?, amountTotal=?,detail=? where id_product=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(editsql);
            preparedStatement.setString(1, product.getNameproduct());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4,product.getAmountTotal());
            preparedStatement.setString(5,product.getDetail());
            preparedStatement.setInt(6, product.getId_product());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static List<Category> getALLCategory() {
        String sql = "select * from Category";
        List<Category> categories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_Category = resultSet.getInt("id_Category");
                String style = resultSet.getString("style");
                double categoryAmount = resultSet.getDouble("categoryAmount");
                categories.add(new Category(id_Category,style,categoryAmount));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }return categories;
    }
    public static List<Product> getByIdCategory(int id) {
        String sql = "select * from Product where idCategory = '" + id + "'";
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id_product = resultSet.getInt("id_product");
                String nameproduct = resultSet.getString("nameproduct");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                int amountTotal = resultSet.getInt("amountTotal");
                String detail = resultSet.getString("detail");
                products.add(new Product(id_product, nameproduct, img, price, amountTotal, detail));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }return products;
    }

}
