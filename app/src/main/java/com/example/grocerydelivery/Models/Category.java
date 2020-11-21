package com.example.grocerydelivery.Models;

public class Category {
    public String category_name,category_url,key;

    public Category() {
    }

    public void setCategory_name(String cat_name) {
        this.category_name = cat_name;
    }

    public String getCategory_url() {
        return category_url;
    }

    public void setCategory_url(String cat_url) {
        this.category_url = cat_url;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
