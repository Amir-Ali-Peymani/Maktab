package org.example.entity;

import org.example.base.entity.BaseEntity;

public class product extends BaseEntity<Integer> {
    private String name;

    private int price;

    private int categoryId;

    private int count;

    public product(String name, int price, int categoryId, int count) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.count = count;
    }

    public product(Integer integer, String name, int price, int categoryId, int count) {
        super(integer);
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
