package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<State> states = new ArrayList<>();
    public static String KEY = "bundle.key" , KEY2 = "bundle.key2", KEY3 = "bundle.key3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        Bundle bundle = new Bundle();
        BlankFragment blankFragment = new BlankFragment();

        StateAdapter.OnStateClickListener stateClickListener = (state, position) -> {
            bundle.putString(KEY2,state.getCapital());
            bundle.putString(KEY, state.getName());
            bundle.putString(KEY3, state.getFlagResource());
            blankFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(R.id.conteiner, blankFragment).addToBackStack(null).commit();
            Toast.makeText(getApplicationContext(), "Был выбран пункт " + state.getName(),
                    Toast.LENGTH_SHORT).show();
        };
        StateAdapter adapter = new StateAdapter(this, states,stateClickListener);
        recyclerView.setAdapter(adapter);

    }

    private void setInitialData() {
        states.add(new State("Kyrgyzstan","Bishkek", "https://avatars.mds.yandex.net/i?id=b9d7be5542099642faf715629d54b1c8-4495103-images-thumbs&n=13"));
        states.add(new State("UK", "London", "https://avatars.mds.yandex.net/i?id=9078782891f77b094598fa164ff086c0-4411346-images-thumbs&n=13"));
        states.add(new State("Ukraine", "Kiev", "https://avatars.mds.yandex.net/i?id=426e5de22e7239812b3674582aa8e17c-4055801-images-thumbs&n=13"));
        states.add(new State("USA", "Washington", "https://avatars.mds.yandex.net/i?id=3268dc4a8ad02b52df5962f49c35f3e8-5432202-images-thumbs&n=13"));
        states.add(new State("Russia", "Moscow", "https://klike.net/uploads/posts/2020-09/1599833816_2.jpg"));
        states.add(new State("Kazakhtan","Astana","https://avatars.mds.yandex.net/i?id=da938e68a76df73fd614c08d75de23da-5427440-images-thumbs&n=13"));
        states.add(new State("Uzbekistan","Taskent","https://avatars.mds.yandex.net/i?id=023a10d5102c8228dc7d3f738d13a903-5285663-images-thumbs&n=13"));
        states.add(new State("Korea","Seul","https://avatars.mds.yandex.net/i?id=78eedb52c3caf220a65923702a2735fa-5235028-images-thumbs&n=13"));
        states.add(new State("Japan","Tokyo","https://avatars.mds.yandex.net/i?id=e78225f87c6e22bc19ab1ed4597a968a-5236662-images-thumbs&n=13"));
        states.add(new State("Egypt","Kair","https://avatars.mds.yandex.net/i?id=4bccbd3cee2c779ddc4085ca39b0de11-5323298-images-thumbs&n=13"));
        states.add(new State("China","Pekin","https://avatars.mds.yandex.net/i?id=316f543427ddd6077832f925786b32b4-5479024-images-thumbs&n=13"));
        states.add(new State("Germany","Berlin","https://avatars.mds.yandex.net/i?id=6a70db1b60fc6e1194c88a1ad46e5d5e-5335549-images-thumbs&n=13"));
        states.add(new State("French","Paris","https://avatars.mds.yandex.net/i?id=f4e833dabcca0b2bb414559ed4423cf7-4078555-images-thumbs&n=13"));
        states.add(new State("Mexico","Mehico","https://avatars.mds.yandex.net/i?id=a6abb8c920be1a5af4b826e894611ad9-3578623-images-thumbs&n=13"));
        states.add(new State("Poland","Varchawa","https://avatars.mds.yandex.net/i?id=b2f463b464e17270069142558a4c971f-5086991-images-thumbs&n=13"));

    }
}