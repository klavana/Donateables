package com.example.a4g_ksd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void moveToAddItemToList(View v) {
        Intent intent = new Intent(this, AddItemToList.class);
        startActivity(intent);
    }
    public void ViewOrgReq(View v) {
        Intent intent = new Intent(this, ViewOrgReq.class);
        String OrgReq = "Placeholder";
        intent.putExtra("key1", OrgReq);
        startActivity(intent);
    }
    public void UserOffers(View v) {
        Intent intent = new Intent(this, UserOffers.class);
        final Controller controller = (Controller) getApplicationContext();
        String CompOffer = controller.getUser().getMyItemsList();
        intent.putExtra("key3", CompOffer);
        startActivity(intent);
    }

    public void moveToSettings(View v) {
        Intent intent = new Intent(this, SettingsProfile.class);
        startActivity(intent);
    }
}
