package org.example.service.cart;

import org.example.base.service.BaseService;
import org.example.entity.Cart;

public interface CartService extends BaseService<Integer , Cart> {

    boolean doesUserIdExist(String id) throws Exception;
}
