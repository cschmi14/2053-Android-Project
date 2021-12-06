package com.example.project3;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>{

    private LayoutInflater mInflater;
    private Context context;
    private LinkedList<Pokemon> pokemon;

    public PokemonAdapter(Context context, LinkedList<Pokemon> pokemon)
    {
        //TODO: Add data to constructor, initialize everything
        mInflater = LayoutInflater.from(context);
        this.pokemon = pokemon;
        this.context = context;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mPokemonView = mInflater.inflate(R.layout.pokemon_item, parent, false);
        return new PokemonViewHolder(mPokemonView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        // TODO: Set view holder properties to appropriate info
        Pokemon currentPoke = pokemon.get(position);
        holder.mName.setText(currentPoke.getName());
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mName;
        private PokemonAdapter adapter;
        public PokemonViewHolder(View itemView, PokemonAdapter adapter) {
            super(itemView);
            // TODO: find views by id
            mName = (TextView) itemView.findViewById(R.id.pokemon_name);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, PokemonDetailActivity.class);
            int mPosition = getLayoutPosition();
            intent.putExtra("NAME", pokemon.get(mPosition).getName());
            intent.putExtra("STATS", pokemon.get(mPosition).getStats());
            intent.putExtra("ICON", pokemon.get(mPosition).getIcon());
            intent.putExtra("TYPE", pokemon.get(mPosition).getTypeA());
            intent.putExtra("DEXNUMBER", pokemon.get(mPosition).getDexNumber());
            context.startActivity(intent);
        }
    }
}
