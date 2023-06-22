package org.example.service.cart.impl;

import org.example.base.service.BaseService;
import org.example.entity.Cart;
import org.example.repository.cart.CartRepository;
import org.example.service.cart.CartService;

import java.sql.SQLException;

public class CartServiceImpl
        implements CartService, BaseService<Integer, Cart> {
    @Override
    public void save(Cart entity) throws SQLException {

    }

    @Override
    public void delete(Integer integer) throws SQLException {

    }

    @Override
    public Cart findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public void update(Cart entity) throws SQLException {

    }

    @Override
    public boolean doesUserIdExist(String id) throws Exception {
        return false;
    }
}
