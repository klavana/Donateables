package com.example.a4g_ksd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainOrgPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_orgpage);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void moveToAddItemToList(View v) {
        Intent intent = new Intent(this, addItemAsOrg.class);
        startActivity(intent);
    }
    public void moveToSettings(View v) {
        Intent intent = new Intent(this, SettingsProfile.class);
        startActivity(intent);
    }
    public void ViewOrgReq(View v) {
        Intent intent = new Intent(this, OrgRequests.class);
        startActivity(intent);
    }
}
