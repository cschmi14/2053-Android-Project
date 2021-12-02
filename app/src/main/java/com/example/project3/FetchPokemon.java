package com.example.project3;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchPokemon extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mName;
//    private WeakReference<ImageView> mIcon;
//    private WeakReference<TextView> mStats;
//    private WeakReference<TextView> mDescription;
//    private WeakReference<TextView> mType;
//    private WeakReference<TextView> mDexNumber;

    FetchPokemon(TextView mName, TextView mStats, TextView mDescription, TextView mType, TextView mDexNumber, ImageView mIcon) {
        this.mName = new WeakReference<>(mName);
//        this.mStats = new WeakReference<>(mStats);
//        this.mDescription = new WeakReference<>(mDescription);
//        this.mType = new WeakReference<>(mType);
//        this.mDexNumber = new WeakReference<>(mDexNumber);
//        this.mIcon = new WeakReference<>(mIcon);
    }

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

        //Create a String with the reponse
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        String jsonString = builder.toString();
        Log.d("FetchBookTagJsonString", jsonString);
        return jsonString;
    }

    @Override
    protected String doInBackground(String... strings) {
        String jsonString = null;
        try {
            jsonString = getPokemonInfo(strings[0]);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    protected void onPostExecute(String x) {
        super.onPostExecute(x);
        String mName = null;
//        String mDescription = null;
//        String mType = null;
//        String mDexNumber = null;
//        String mIcon = null;
//        String[] mStats = null;
        JSONObject jsonObject = null;
        JSONArray itemsArray = null;
        int i = 0;
        try {
            JSONObject object = new JSONObject(x);
            JSONObject name = object.getJSONObject("name");
//            while (i<itemsArray.length() && mName == null /* && mDescription == null && mType == null && mDexNumber == null && mIcon == null && mStats == null */) {
//                JSONObject pokemon = itemsArray.getJSONObject(i);
//                JSONObject dex = pokemon.getJSONObject("dex");
//                title = volumeInfo.getString("title");
//                author = volumeInfo.getString("authors");
//                mName.get().setText(mName);
//                mTitleText.get().setText(title);
//                i++;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

