package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StateAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final LayoutInflater inflater;
    private final ArrayList<State> states;
    private final OnStateClickListener onStateClick;
    StateAdapter(Context context, ArrayList<State> states, OnStateClickListener onStateClick) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
        this.onStateClick = onStateClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_name, parent, false);
        return new ViewHolder(view);
    }
    interface OnStateClickListener{
        void onStateClick(State state, int position);
    }
    private ImageView imageView;
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        State state = states.get(position);
        holder.nameView.setText(state.getName());
        holder.capitalView.setText(state.getCapital());
        Picasso.get().load(state.getFlagResource()).into(holder.flagView);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // вызываем метод слушателя, передавая ему данные
                onStateClick.onStateClick(state, position);
            }
    });

}

    @Override
    public int getItemCount() {
        return states.size();
    }
}

