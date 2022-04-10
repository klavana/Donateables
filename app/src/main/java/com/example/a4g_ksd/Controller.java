package com.example.a4g_ksd;

import android.app.Application;
import android.widget.EditText;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Controller extends Application {
    //EditText name = findViewById(R.id.editItemQuantity);

    public User getUser() {
        User testUser = new User("name", "location", "mail");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");
        myRef.push().setValue(testUser);

        return testUser;
    }

    public Organization getOrg(){
        Organization testOrg = new Organization("name", "location", "mail");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("organizations");
        myRef.push().setValue(testOrg);

        return testOrg;
    }

}
