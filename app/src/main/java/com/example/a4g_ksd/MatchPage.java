package com.example.a4g_ksd;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;

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

    ArrayList<Match> matches;
    RecyclerView recyclerView;
    MatchAdapter adapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermatch);

        genRef = FirebaseDatabase.getInstance().getReference("users/general/"+ MainActivity.user.getUserName() +"/items");
        orgRef = FirebaseDatabase.getInstance().getReference("items/organizations");

        recyclerView = findViewById(R.id.matchesRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Item> userItems = new ArrayList<Item>();

        genRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Item item = dataSnapshot.getValue(Item.class);
                    userItems.add(item);
                    Log.d("Match: ",item.getName());

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        ArrayList<Item> orgItems = new ArrayList<Item>();
        orgRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Item item = dataSnapshot.getValue(Item.class);
                    orgItems.add(item);
                    Log.d("Match: ",item.getName());

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        Log.d("Match: ",userItems + " "+ orgItems);
       matches = Match.getMatchList(userItems, orgItems);
        adapter = new MatchAdapter(this,matches);
        recyclerView.setAdapter(adapter);

    }

   /* private ArrayList<Item> toArrayList(DatabaseReference ref){
        Log.d("Match","in match page make list");
        ArrayList<Item> list = new ArrayList<Item>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Item item = dataSnapshot.getValue(Item.class);
                    Log.d("Item", item.getName());
                    list.add(item);
                }
                Log.d("Item1"," " + list);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        Log.d("Item2"," " + list.size());
        return list;*/
    }
