package org.example.repostitory;


import org.example.config.MyConnection;
import org.example.entity.Category;

import java.sql.*;

public class CategoryRepository {

    public void saveCategory(Category category) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "insert into category( name, description) values (?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getDescription());
        preparedStatement.executeUpdate();
    }
    public Category loadCategory(int Id) throws SQLException {
        String name = "";
        String description = "";
        Connection connection = MyConnection.getConnection();
        String sql = "SELECT * FROM category where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            name = resultSet.getString("name");
            description = resultSet.getString("description");
        }
        Category category = new Category(name, description);
        resultSet.close();
        preparedStatement.close();
        return category;
    }
    public void updateCategory(int id, int input, String input1) throws SQLException {
        Connection connection = MyConnection.getConnection();
        if (input == 1){
            String sql = "update category set name = ? where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, input1);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        }
        if (input == 2){
            String sql = "update category set description = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }
    public void categoryDelete(int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "DELETE FROM category where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
