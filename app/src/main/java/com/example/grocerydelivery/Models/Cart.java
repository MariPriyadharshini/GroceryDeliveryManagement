package com.example.grocerydelivery.Models;

public class Cart {
    public String user_name,cart_key;
    public String product_key;

    public Cart() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getP() {
        return product_key;
    }


    public void setP(String p) {
        this.product_key = p;
    }

    public String getCart_key() {
        return cart_key;
    }

    public void setCart_key(String key) {
        this.cart_key = key;

    }
}
