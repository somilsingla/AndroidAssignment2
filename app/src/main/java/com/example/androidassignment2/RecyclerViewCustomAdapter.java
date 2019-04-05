package com.example.androidassignment2;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewCustomAdapter extends RecyclerView.Adapter<RecyclerViewCustomAdapter.ViewHolder> {
    List<item> items;
    Activity context;

    public RecyclerViewCustomAdapter(List<item> items, Activity context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Inflate view and create ViewHolder
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        item item = items.get(position);
        holder.name.setText(item.getName());
        holder.message.setText(item.getMessage());
        }

    @Override
    public int getItemCount() {
        return items.size();
    }




    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView message;
        ImageView icon;
        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            message = v.findViewById(R.id.message);
            icon = v.findViewById(R.id.icon);
        }
    }

}
