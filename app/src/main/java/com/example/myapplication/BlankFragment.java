package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    private  ArrayList<State> states;
private ImageView imageView;
    private TextView textCountry, textCapital;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.image_view2);
        textCapital = view.findViewById(R.id.text_capital);
        textCountry = view.findViewById(R.id.text_name);

        if (getArguments() != null){
            String value = getArguments().getString(MainActivity.KEY);
            textCountry.setText(value);
            String valu = getArguments().getString(MainActivity.KEY2);
            textCapital.setText(valu);
            Picasso.get().load(getArguments().getString(MainActivity.KEY3)).into(imageView);
        }
    }
}