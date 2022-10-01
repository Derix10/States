package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    final ImageView flagView;
    final TextView nameView, capitalView;

    public ViewHolder(@NonNull View view) {
        super(view);
        flagView = view.findViewById(R.id.flag);
        nameView = view.findViewById(R.id.name);
        capitalView = view.findViewById(R.id.capital);
    }
}
