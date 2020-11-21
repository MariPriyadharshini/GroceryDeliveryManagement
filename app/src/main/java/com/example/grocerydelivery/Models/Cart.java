package com.example.grocerydelivery.Models;

public class Cart {
    public String user_name,cart_key;
    public Product p;

    public Cart() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Product getP() {
        return p;
    }


    public void setP(Product p) {
        this.p = p;
    }

    public String getCart_key() {
        return cart_key;
    }

    public void setCart_key(String key) {
        this.cart_key = key;

    }
}
