package com.example.a4g_ksd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addItemAsOrg extends AppCompatActivity {
    //Data
    EditText editItemQuantity, editItemName;
    String quantityStr;
    int quantity;
    String name;

    @Override
    //"Constructor"
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_as_org);
        editItemQuantity= findViewById(R.id.editQuantityOrg);
        editItemName = findViewById(R.id.EditItemNameOrg);
        Intent intent = getIntent();
    }
    public void myRequests(View v) {
        Intent intent = new Intent(this, OrgRequests.class);
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

    public void addRequest(View v){
        Item i = new Item(getName(), getQuantity(), MainActivity.org);
        MainActivity.org.addItem(i);
        Toast.makeText(getApplicationContext(),"Add Offer",Toast.LENGTH_SHORT).show();
        displayInfo();
        readItemDataFB(i);

    }

    private void readItemDataFB(Item i){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("items/organizations");
        myRef.push().setValue(i);
        DatabaseReference myRef2 = database.getReference("users/organizations/"+MainActivity.org.getUserName()+"/items");
        myRef2.push().setValue(i);
    }

    private void displayInfo(){
        final Controller controller = (Controller) getApplicationContext();
        TextView itemNameText = findViewById(R.id.itemNameDisp);
        TextView itemQuantityText = findViewById(R.id.itemQuantityDisp);
        TextView addressText = findViewById(R.id.addressDisp);
        itemNameText.setText("Item Name: " + getName());
        itemQuantityText.setText("Quantity: " + getQuantity());
    }
}
