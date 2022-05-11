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
    public void moveToMatchPage(View v) {
        Intent intent = new Intent(this, OrgMatchPage.class);
        startActivity(intent);
    }
    public void OrgReq(View v) {
        Intent intent = new Intent(this, OrgRequests.class);
        startActivity(intent);
    }

    public void toViewDonateables(View v) {
        Intent intent = new Intent(this, ViewDonateables.class);
        startActivity(intent);
    }
}
