package org.example.entity;

import org.example.base.entity.BaseEntity;

import java.util.Date;

public class Cart extends BaseEntity<Integer> {
    private int userId;

    private Date date;

    public Cart(int userId, Date date) {
        this.userId = userId;
        this.date = date;
    }

    public Cart(Integer integer, int userId, Date date) {
        super(integer);
        this.userId = userId;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
