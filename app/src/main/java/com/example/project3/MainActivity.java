package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PokemonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinkedList<Pokemon> pokeList = new LinkedList<Pokemon>();
        int[] stats = {1,1,1,1,1,1};
        Pokemon Bulbasaur = new Pokemon("Bulbasaur", stats, "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", "descURL", "Grass", 1);


        pokeList.add(Bulbasaur);
//        for (int i = 0; i < 10; i++) {
//            getPokemonInfo(Integer.toString(i))
//        }
        mRecyclerView = findViewById(R.id.main_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new PokemonAdapter(this, pokeList);
        mRecyclerView.setAdapter(mAdapter);
    }
}