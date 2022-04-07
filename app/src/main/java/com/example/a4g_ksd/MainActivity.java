package com.example.a4g_ksd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Object User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void moveToAddItemToList(View v) {
        Intent intent = new Intent(this, AddItemToList.class);
        startActivity(intent);
    }
    public void ViewOrgReq(View v) {
        Intent intent = new Intent(this, ViewOrgReq.class);
        String OrgReq = Double.toString(42);
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


}