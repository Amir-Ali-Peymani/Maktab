package org.example.entity;

import org.example.base.entity.BaseEntity;

import java.util.Date;

public class category extends BaseEntity<Integer> {
    private String name;

    public category(String name) {
        this.name = name;
    }

    public category(Integer integer, String name) {
        super(integer);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
