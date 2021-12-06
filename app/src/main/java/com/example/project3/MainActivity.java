package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PokemonAdapter mAdapter;
    private LinkedList<Pokemon> pokeList = new LinkedList<Pokemon>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pokemon Bulbasaur = new Pokemon();
        int[] stats = {1,1,1,1,1,1};
        Bulbasaur.setName("Bulbasaur");
        Bulbasaur.setStats(stats);
        Bulbasaur.setIcon("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png");
        Bulbasaur.setType("Grass");
        Bulbasaur.setDexNumber(1);
        pokeList.add(Bulbasaur);

        mRecyclerView = findViewById(R.id.main_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new PokemonAdapter(this, pokeList);
        mRecyclerView.setAdapter(mAdapter);
//
        for (int i = 1; i < 10; i++) {
            load_data(i);
        }


    }

    private void load_data(int i) {
        AsyncTask<String, Void, String> task = new AsyncTask <String, Void, String>() {
            protected String getPokemonInfo(String query) throws IOException {
                //Pokemon API URL
                String apiURL = "https://pokeapi.co/api/v2/pokemon/";
                //Append query
                apiURL += query;

                //Make connection to API
                URL requestURL = new URL(apiURL);
                HttpURLConnection urlConnection = (HttpURLConnection) requestURL.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                //Receive the response
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                //Create a String with the response
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append("\n");
                }
                String jsonString = builder.toString();
                return jsonString;
            }

            @Override
            protected String doInBackground(String... strings) {
                String jsonString = null;
                try {
                    jsonString = getPokemonInfo(strings[0]);
//                    Pokemon pkmn = parseJson(jsonString);
//                    Log.d("name", pkmn.getName());
//                    pokeList.add(pkmn);
                } catch(IOException e) {
                    e.printStackTrace();
                }
                return jsonString;
            }

            @Override
            protected void onPostExecute(String x) {
                Pokemon pkmn = parseJson(x);
                Log.d("POKEMONS NAME", pkmn.getName());
                Log.d("BEFORE ADDING", Integer.toString(pokeList.size()));
                pokeList.add(pkmn);

                Log.d("MESSAGE HERE", Integer.toString(pokeList.size()));
                mAdapter.notifyDataSetChanged();
                Log.d("Shoulda updated", "ME");
            }

            private Pokemon parseJson(String json) {
                try {
                    JSONObject json_name = new JSONObject(json);
                    String pkmn_name = json_name.getString("name");
                    Pokemon pkmn = new Pokemon();
                    pkmn.setName(pkmn_name);
                    return pkmn;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        task.execute(Integer.toString(i));
        Log.d("MAN", "I LOVE POP");
    }
}