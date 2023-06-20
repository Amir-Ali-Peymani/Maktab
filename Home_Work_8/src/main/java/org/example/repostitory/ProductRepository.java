package org.example.repostitory;

import org.example.config.MyConnection;
import org.example.entity.Product;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProductRepository {

    public void saveProduct(Product product) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "insert into product(name, create_date, category_id, brand_id) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setDate(2, new Date(product.getCreated_date().getTime()));
        preparedStatement.setInt(3, product.getCategory_id());
        preparedStatement.setInt(4,product.getBrand_id());
        preparedStatement.executeUpdate();
    }
    public Product loadProduct(int Id) throws SQLException{
        String name = "";
        Date created_date = null;
        int category_id = 0;
        int brand_id = 0;
        Connection connection = MyConnection.getConnection();
        String sql = "select * from product where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,Id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            name = resultSet.getString("name");
            created_date = resultSet.getDate("create_date");
            category_id = resultSet.getInt("category_id");
            brand_id = resultSet.getInt("brand_id");
        }
        Product product = new Product(name, created_date, category_id, brand_id);
        resultSet.close();
        preparedStatement.close();
        return  product;
    }
    public void updateProduct(int id, int input, String input1) throws SQLException, ParseException {
        Connection connection = MyConnection.getConnection();
        if (input == 1){
            String sql = "update product set name = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, input1);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        }
        if (input == 2){
            String sql = "update product set create_date = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(input1);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        }
        if (input == 3){
            String sql = "update product set category_id = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int categoryId = Integer.parseInt(input1);
            preparedStatement.setInt(1, categoryId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        if (input == 4){
            String sql = "update product set brand_id = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int categoryId = Integer.parseInt(input1);
            preparedStatement.setInt(1,categoryId);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }
    public void productDelete(int id) throws SQLException{
        Connection connection = MyConnection.getConnection();
        String sql = "delete from product where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
