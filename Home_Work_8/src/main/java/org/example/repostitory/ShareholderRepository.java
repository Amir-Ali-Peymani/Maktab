package org.example.repostitory;

import org.example.config.MyConnection;
import org.example.entity.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareholderRepository {
    public void saveShareholder(Shareholder shareholder) throws SQLException{
        Connection connection = MyConnection.getConnection();
        String sql = "insert into shareholder(name , phone_number, national_code) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, shareholder.getName());
        preparedStatement.setString(2, shareholder.getPhoneNumber());
        preparedStatement.setString(3, shareholder.getNationalCode());
        preparedStatement.executeUpdate();
    }
    public Shareholder loadShareholder(int Id) throws SQLException{
        String name = "";
        String phone_number = "";
        String national_code = "";
        Connection connection = MyConnection.getConnection();
        String sql = "select * from shareholder where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            name = resultSet.getString("name");
            phone_number = resultSet.getString("phone_number");
            national_code = resultSet.getString("national_code");
        }
        Shareholder shareholder = new Shareholder(name, phone_number, national_code);
        resultSet.close();
        preparedStatement.close();
        return shareholder;
    }
    public void updateShareholder(int id, int input, String input1) throws SQLException{
        Connection connection = MyConnection.getConnection();
        if (input == 1){
            String sql = "update shareholder set name = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        if (input == 2){
            String sql = "update shareholder set phone_number = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        if (input == 3){
            String sql = "update shareholder set national_code = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }
    public void shareholderDelete(int id ) throws SQLException{
        Connection connection = MyConnection.getConnection();
        String sql = "delete from shareholder where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
