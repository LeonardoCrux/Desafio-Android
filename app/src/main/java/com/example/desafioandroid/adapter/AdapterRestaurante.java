package com.example.desafioandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafioandroid.R;
import com.example.desafioandroid.model.Restaurante;

import java.util.List;

public class AdapterRestaurante extends RecyclerView.Adapter<AdapterRestaurante.MyViewHolder> {
    private List<Restaurante> restaurante;

    public AdapterRestaurante(List<Restaurante> listaRestaurante){
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
        final Restaurante rest = restaurante.get( position);
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
        private TextView nomeRestaurante, enderecoRestaurante, horarioRestaurante;
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
