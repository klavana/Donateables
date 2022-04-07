package com.example.a4g_ksd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        Toast.makeText(getApplicationContext(),"Add Item to List Working",Toast.LENGTH_SHORT).show();
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
        final Controller controller = (Controller) getApplicationContext();
        controller.getUser().addItem(i);
        Toast.makeText(getApplicationContext(),"Add Offer",Toast.LENGTH_SHORT).show();
        displayInfo();

    }

    private void displayInfo(){
        final Controller controller = (Controller) getApplicationContext();
        TextView itemNameText = findViewById(R.id.itemNameDisp);
        TextView itemQuantityText = findViewById(R.id.itemQuantityDisp);
        TextView addressText = findViewById(R.id.addressDisp);
        itemNameText.setText("Item Name: " + getName());
        itemQuantityText.setText("Quantity: " + getQuantity());
        addressText.setText("Pick-up Address: " + controller.getUser().getAddress());
    }
}
