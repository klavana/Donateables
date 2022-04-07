package com.example.a4g_ksd;

import android.app.Application;

public class Controller extends Application {
    User testUser = new User("name", "location", "mail");

    public User getUser() {
        return testUser;
    }

}
