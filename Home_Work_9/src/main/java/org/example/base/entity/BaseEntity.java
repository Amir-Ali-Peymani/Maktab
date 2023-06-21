package org.example.base.entity;

public class BaseEntity <ID>{

    protected ID id;

    public BaseEntity(){
    }

    public BaseEntity(ID id){
        this.id = id;
    }

    public ID getId(){
        return id;
    }
}
