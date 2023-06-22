//package org.example.repository.cart.impl;
//
//import org.example.base.repository.impl.BaseRepositoryImpl;
//import org.example.config.MyConnection;
//import org.example.entity.Cart;
//import org.example.exception.UserIdExistException;
//import org.example.exception.UsernameExistException;
//import org.example.repository.cart.CartRepository;
//import org.example.util.Constant;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class CartRepositoryImpl
//        extends BaseRepositoryImpl<Integer, Cart>
//        implements CartRepository {
//
//    @Override
//    public String getTableName() {
//        return "cart";
//    }
//
//    @Override
//    public String getColumnsName() {
//        return "(userid, date)";
//    }
//
//    @Override
//    public String getUpdateQueryParams() {
//        return "userid = ? , date = ?";
//    }
//
//    @Override
//    public String getCountOfQuestionMarks() {
//        return "?, ?";
//    }
//
//    @Override
//    public Cart mapResultSetToEntity(ResultSet resultSet) throws SQLException {
//        return new Cart(resultSet.getInt(1),
//                resultSet.getInt(2),
//                resultSet.getDate(3));
//    }
//
//    @Override
//    public void fillParamForStatement(PreparedStatement preparedStatement, Cart entity) throws SQLException {
//        preparedStatement.setString(1,entity.getUserId());
//        preparedStatement.setString(2,entity.getDate());
//    }
//
//    @Override
//    public boolean doesUserIdExist(String id) throws SQLException, UserIdExistException {
//        String sql = "SELECT id FROM " + getTableName() + " WHERE id = ?";
//        try{PreparedStatement preparedStatement = new MyConnection().getConnection().prepareStatement(sql);
//            preparedStatement.setString(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next())
//                throw new UserIdExistException(Constant.USER_EXIST);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return false;
//    }
//}
