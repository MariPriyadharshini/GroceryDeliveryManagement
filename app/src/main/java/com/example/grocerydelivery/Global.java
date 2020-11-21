package com.example.grocerydelivery;

import android.app.Application;

public class Global extends Application {
    public String user_name;

    public Global() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
