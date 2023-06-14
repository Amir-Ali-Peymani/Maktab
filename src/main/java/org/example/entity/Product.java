package org.example.entity;

import java.util.Date;

public class Product {
    long user_id;
    private String name;
    private Date created_date;
    private int category_id;
    private int brand_id;
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public Product(long user_id, String name, Date created_date, int category_id, int brand_id) {
        this.user_id = user_id;
        this.name = name;
        this.created_date = created_date;
        this.category_id = category_id;
        this.brand_id = brand_id;
    }

    public Product(String name, Date created_date, int category_id, int brand_id) {
        this.name = name;
        this.created_date = created_date;
        this.category_id = category_id;
        this.brand_id = brand_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }
}
