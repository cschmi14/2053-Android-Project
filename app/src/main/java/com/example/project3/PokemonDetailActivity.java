package com.example.project3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import com.squareup.picasso.Picasso;

public class PokemonDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView pokemonDetailView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        Intent intent = getIntent();
        imageView = findViewById(R.id.imageView);
        pokemonDetailView = findViewById(R.id.pokemonDetailView);
        String imageURL = intent.getStringExtra("ICON");
        String name = intent.getStringExtra("NAME");
        int[] stats = intent.getIntArrayExtra("STATS");
        //int dexNumber = intent.getIntExtra("DEXNUMBER");
        String description = intent.getStringExtra("DESCRIPTION");
        String type = intent.getStringExtra("TYPE");

        String detailString = "";
        detailString += "NAME: " + name + "\n\n";
        detailString += "TYPE: " + type + "\n\n";
        detailString += "STATS: " + "\n";
        detailString += "Hp = " + stats[0] + "\n";
        detailString += "Attack = " + stats[1] + "\n";
        detailString += "Defense = " + stats[2] + "\n";
        detailString += "Special-Attack = " + stats[3] + "\n";
        detailString += "Special-Defense = " + stats[4] + "\n";
        detailString += "Speed = " + stats[5] + "\n\n";
        pokemonDetailView.setText(detailString);
        Picasso.get().load(imageURL).into(imageView);

    }
}