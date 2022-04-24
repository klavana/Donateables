package com.example.a4g_ksd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsProfile extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_profile);
        TextView email = findViewById(R.id.textView3);
        TextView addy = findViewById(R.id.textView6);
        TextView instr = findViewById(R.id.textView8);
        Intent intent = getIntent();
        final Controller controller = (Controller) getApplicationContext();
        addy.setText(" " + controller.getUser().getAddress());
        email.setText(" " + controller.getUser().getEmail());
        //instr.setText(" " + controller.getUser().getInstr());
    }

}
