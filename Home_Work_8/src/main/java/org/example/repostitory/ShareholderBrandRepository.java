package org.example.repostitory;

import org.example.config.MyConnection;
import org.example.entity.ShareholderBrand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareholderBrandRepository {
    public void saveShareholderBrandRepository(ShareholderBrand shareholderBrand) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "insert into shareholderbrand (shareholder_id, brand_id) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, shareholderBrand.getShareholder());
        preparedStatement.setInt(2, shareholderBrand.getBrandId());
        preparedStatement.executeUpdate();
    }
    public ShareholderBrand loadShareholderBrand(int Id) throws SQLException{
        int shareholder_id = 0;
        int brand_id = 0;
        Connection connection = MyConnection.getConnection();
        String sql = "select * from shareholderbrand where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            shareholder_id = resultSet.getInt("shareholder_id");
            brand_id = resultSet.getInt("brand_id");
        }
        ShareholderBrand shareholderBrand = new ShareholderBrand(shareholder_id, brand_id);
        resultSet.close();
        preparedStatement.close();
        return shareholderBrand;
    }
    public void updateShareholderBrand(int id, int input, int input1) throws SQLException {
        Connection connection = MyConnection.getConnection();
        if (input == 1){
            String sql = "update shareholderbrand set shareholder_id = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,input1);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        }
        if (input == 2){
            String sql = "update shareholderbrand set brand_id = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,input1);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        }
    }
    public void shareholderDelete(int id ) throws SQLException{
        Connection connection = MyConnection.getConnection();
        String sql = "delete from shareholderbrand where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
