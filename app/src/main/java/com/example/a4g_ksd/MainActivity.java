package com.example.a4g_ksd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
// karisma commit
public class MainActivity extends AppCompatActivity {

    static User user ;
    static Organization org;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private String nameToString(){
        EditText name = findViewById(R.id.enterNameEditText);
        String nameStr = name.getText().toString();
        return nameStr;
    }

    private String locationToString(){
        EditText location = findViewById(R.id.enterAddressEditText);
        String locationStr = location.getText().toString();
        return locationStr;
    }

    private String mailToString(){
        EditText mail = findViewById(R.id.enterEmailEditText);
        String mailStr = mail.getText().toString();
        return mailStr;
    }

    public void setUser(View v) {

        user = new User(nameToString(), locationToString(), mailToString());

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users/general");
            DatabaseReference childRef1 = myRef.child(nameToString());
            childRef1.push().setValue(user);

            Toast.makeText(getApplicationContext(),user.getUserName(),Toast.LENGTH_SHORT).show();

    }

    public void setOrg(View v) {
        org = new Organization(nameToString(), locationToString(), mailToString());
        Toast.makeText(getApplicationContext(),"Set Org",Toast.LENGTH_SHORT).show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users/organizations");
            DatabaseReference childRef1 = myRef.child(nameToString());
            childRef1.push().setValue(org);

        Toast.makeText(getApplicationContext(),org.getUserName(),Toast.LENGTH_SHORT).show();

    }

    public void moveToMainPage(View v) {
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }


}