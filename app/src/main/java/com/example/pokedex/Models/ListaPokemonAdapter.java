package com.example.pokedex.Models;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokedex.R;

import java.util.ArrayList;

public class ListaPokemonAdapter  extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder>
 {

    private ArrayList<Pokemon> dataset;
    private Context context;

    public ListaPokemonAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(ViewHolder holder, int position){
        Pokemon p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());
        Glide.with(context).load("http://pokeapi.co/media/sprites/pokemon/"+p.getNumber()+".png")
                .centerCrop()
                //.crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);
    }

    public int getItemCount(){
        return 0;
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoImageView;
        private TextView nombreTextView;
        public ViewHolder(View itemView) {
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
        }
    }
}
