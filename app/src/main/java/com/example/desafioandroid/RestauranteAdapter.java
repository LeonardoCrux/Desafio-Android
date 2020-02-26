package com.example.desafioandroid;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.MyViewHolder> {
    private List<Restaurante> restaurante;

    public RestauranteAdapter(List<Restaurante> listaRestaurante){
        this.restaurante = listaRestaurante;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurante_detalhe, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Restaurante rest = restaurante.get( position);
        holder.nomeRestaurante.setText( rest.getNome());
        holder.enderecoRestaurante.setText( rest.getEndereco());
        holder.imagemRestaurante.setImageResource( rest.getImagem());
        holder.horarioRestaurante.setText(rest.getHorario());

    }

    @Override
    public int getItemCount() {
        return restaurante.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeRestaurante;
        private TextView enderecoRestaurante;
        private TextView horarioRestaurante;
        private ImageView imagemRestaurante;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            nomeRestaurante = itemView.findViewById(R.id.nomeRestaurante);
            enderecoRestaurante = itemView.findViewById(R.id.enderecoRestaurante);
            horarioRestaurante = itemView.findViewById(R.id.horarioRestaurante);
            imagemRestaurante = itemView.findViewById(R.id.imagemRestaurante);
        }
    }

}
