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
       String OrgReq = intent.getStringExtra("key1");

       TextView textViewOrgReqTester = findViewById(R.id.textViewOrgReqTester);
       textViewOrgReqTester.setText(OrgReq);

    }
}

