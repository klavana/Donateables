package com.example.a4g_ksd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddItemToList extends AppCompatActivity {

    //Data
    EditText editItemQuantity, editItemName;
    String quantityStr;
    int quantity;
    String name;

    @Override
    //"Constructor"
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additemtolist);
        // must be initialized in constructor
        editItemQuantity= findViewById(R.id.editItemQuantity);
        editItemName = findViewById(R.id.EditItemName);
        Intent intent = getIntent();
    }
    public void toUserOffers(View v) {
        Intent intent = new Intent(this, UserOffers.class);
        startActivity(intent);
    }

    // Methods
    public String getName(){
        name = editItemName.getText().toString();
        return name;
    }

    public int getQuantity(){
        quantityStr = editItemQuantity.getText().toString();
        quantity = Integer.parseInt(quantityStr);
        return quantity;
    }

    public void addOffer(View v){
        Item i = new Item(getName(), getQuantity());
        MainActivity.user.addItem(i);
        Toast.makeText(getApplicationContext(),"Add Offer",Toast.LENGTH_SHORT).show();
        displayInfo();
        readItemDataFB(i);

    }

    private void readItemDataFB(Item i){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("items");
        myRef.push().setValue(i);
        DatabaseReference myRef2 = database.getReference("users/general/"+MainActivity.user.getUserName()+"/items");
        myRef2.push().setValue(i);

    }



        /*// Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Item i = ds.getValue(Item.class);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("MainActivity", "Failed to read value.", error.toException());
            }
        });*/



    private void displayInfo(){
        //final Controller controller = (Controller) getApplicationContext();
        TextView itemNameText = findViewById(R.id.itemNameDisp);
        TextView itemQuantityText = findViewById(R.id.itemQuantityDisp);
        TextView addressText = findViewById(R.id.addressDisp);
        itemNameText.setText("Item Name: " + getName());
        itemQuantityText.setText("Quantity: " + getQuantity());
        addressText.setText("Pick-up Address: " + MainActivity.user.getAddress());
    }
}
