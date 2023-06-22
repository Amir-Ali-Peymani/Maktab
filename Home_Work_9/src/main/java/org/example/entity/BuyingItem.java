package org.example.entity;

import org.example.base.entity.BaseEntity;

public class BuyingItem extends BaseEntity<Integer> {
    private int productId;

    private int cartId;

    public BuyingItem(int productId, int cartId) {
        this.productId = productId;
        this.cartId = cartId;
    }

    public BuyingItem(Integer integer, int productId, int cartId) {
        super(integer);
        this.productId = productId;
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
