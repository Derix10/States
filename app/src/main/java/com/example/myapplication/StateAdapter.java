package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_name, parent, false);
        return new ViewHolder(view);
    }
    interface OnStateClickListener{
        void onStateClick(State state, int position);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        State state = states.get(position);
        holder.nameView.setText(state.getName());
        holder.capitalView.setText(state.getCapital());
        Picasso.get().load(state.getFlagResource()).into(holder.flagView);
        holder.itemView.setOnClickListener(v -> {
            onStateClick.onStateClick(state, position);
        });

}

    @Override
    public int getItemCount() {
        return states.size();
    }
}

