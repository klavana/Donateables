package com.example.a4g_ksd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrgMatchAdapter extends RecyclerView.Adapter<OrgMatchAdapter.MyViewHolder> {

    //Data
    Context context;
    ArrayList<Match> list;

    //Constructor
    public OrgMatchAdapter(Context context, ArrayList<Match> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.orgmatch,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Match match = list.get(position);
        holder.name.setText(match.getUser().getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public MyViewHolder(@NonNull View matchView) {
            super(matchView);

            name = matchView.findViewById(R.id.itemName);
        }
    }

}
