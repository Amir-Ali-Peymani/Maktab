package org.example.repostitory;

import org.example.config.MyConnection;
import org.example.entity.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRepository {
    public void saveBrand(Brand brand)throws SQLException{
        Connection connection = MyConnection.getConnection();
        String sql = "insert into brand(name, website, description) values (?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brand.getName());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());
        preparedStatement.executeUpdate();
    }
    public Brand loadBrand(int Id) throws SQLException{
        String name = "";
        String website = "";
        String description = "";
        Connection connection = MyConnection.getConnection();
        String sql = "SELECT * FROM brand where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            name = resultSet.getString("name");
            website = resultSet.getString("website");
            description = resultSet.getString("description");
        }
        Brand brand = new Brand(name, website, description);
        resultSet.close();
        preparedStatement.close();
        return brand;
    }
    public void updateBrand(int id, int input, String input1) throws SQLException{
        Connection connection = MyConnection.getConnection();
        if (input == 1){
            String sql = "update brand set name = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        if (input == 2){
            String sql = "update brand set website = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        if (input == 3){
            String sql = "update brand set description = ? where id =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,input1);
            preparedStatement.setInt(2, id);
        }
    }
    public void brandDelete(int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "DELETE FROM brand where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
