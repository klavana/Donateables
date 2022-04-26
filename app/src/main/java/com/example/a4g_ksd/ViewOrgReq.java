package com.example.a4g_ksd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewOrgReq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vieworgreq);
        Intent intent = getIntent();


        // final Controller aController = (Controller) getApplicationContext();
        // String OrgReq = intent.getStringExtra(/*Enter logic here*/);
       /* TextView textViewUserReqTester = findViewById(R.id.pendingOffers);
      //  textViewUserReqTester.setText(OrgReq);
        TextView compOffers = findViewById(R.id.deliveredOffers);
     //   compOffers.setText(OrgReq);

       TextView textViewOrgReqTester = findViewById(R.id.textViewOrgReqTester);
    //   textViewOrgReqTester.setText(OrgReq);*/

    }
}
