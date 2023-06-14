package org.example.entity;

public class Brand {
    long user_id;
    private String name;
    private String website;
    private String description;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public Brand(long user_id, String name, String website, String description) {
        this.user_id = user_id;
        this.name = name;
        this.website = website;
        this.description = description;
    }

    public Brand(String name, String website, String description) {
        this.name = name;
        this.website = website;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
