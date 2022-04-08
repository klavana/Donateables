package com.example.a4g_ksd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Object User;

    //karisma was here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("MainActivity", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("MainActivity", "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Controller controller = (Controller) getApplicationContext();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("items");

        for( Item i: controller.getUser().getMyItems()){
            Log.v("MainActivity", "Item Name:" + i.getName() + "Quantity: " +i.getCount() + "Origin: " + i.getOrigin());
            myRef.push().setValue(i);

            Toast.makeText(getApplicationContext(),"onStart",Toast.LENGTH_SHORT).show();
        }

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