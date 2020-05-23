package org.ftninformatika.kolekcijafilmova.adapter;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.ftninformatika.kolekcijafilmova.R;
import org.ftninformatika.kolekcijafilmova.db.model.Filmovi;

import java.util.List;


public class AdapterLista extends RecyclerView.Adapter<AdapterLista.MyViewHolder> {

    private Context context;
    private List<Filmovi> film;
    private OnItemClickListener listener;


    public AdapterLista(Context context, List<Filmovi> film, OnItemClickListener listener) {
        this.context = context;
        this.film = film;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_prikaz, parent, false);

        return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvNaziv.setText(film.get(position).getmNaziv());
        holder.tvgodFilma.setText(film.get(position).getmCena());
        Picasso.with(context).load(film.get(position).getmImage()).into(holder.ivSlika);

    }

    @Override
    public int getItemCount() {
        return film.size();
    }

    public Filmovi get(int position) {
        return film.get(position);
    }

    public void removeAll() {
        film.clear();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView tvNaziv;
        private TextView tvgodFilma;
        private ImageView ivSlika;
        private OnItemClickListener vhListener;


        MyViewHolder(@NonNull View itemView, OnItemClickListener vhListener) {
            super(itemView);

            ivSlika = itemView.findViewById(R.id.ivSlika);
            tvNaziv = itemView.findViewById(R.id.tvNazivFilma);
            tvgodFilma = itemView.findViewById(R.id.tvgodFilma);
            this.vhListener = vhListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            vhListener.onItemClick(getAdapterPosition());
        }


    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
