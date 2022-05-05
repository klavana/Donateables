package com.example.a4g_ksd;

import android.os.Bundle;
import android.service.autofill.FieldClassification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MatchPage extends AppCompatActivity {

    DatabaseReference genRef;
    DatabaseReference orgRef;
    ArrayList<Item> userItems;
    ArrayList<Item> orgItems;
    ArrayList<Match> matches;
    RecyclerView recyclerView;
    MatchAdapter adapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermatch);

        genRef = FirebaseDatabase.getInstance().getReference("users/general/"+ MainActivity.user.getUserName() +"/items");
        orgRef = FirebaseDatabase.getInstance().getReference("items/organization");

        userItems = toArrayList(genRef);
        orgItems = toArrayList(orgRef);

        recyclerView = findViewById(R.id.matchesRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        matches = match(userItems, orgItems);
        adapter = new MatchAdapter(this,matches);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Item> toArrayList(DatabaseReference ref){
        ArrayList<Item> list = new ArrayList<Item>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Item item = dataSnapshot.getValue(Item.class);
                    list.add(item);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return list;
}
    public ArrayList<Match> match(ArrayList<Item> userItems, ArrayList<Item> orgItems){
        return Match.getMatchList(userItems, orgItems);
    }




}
