package com.example.desafioandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafioandroid.R;
import com.example.desafioandroid.model.Pratos;

import java.util.List;

public class AdapterPratos extends RecyclerView.Adapter<AdapterPratos.MyViewHolder>{
    private List<Pratos> listPratos;
    private Pratos pratos;

    public AdapterPratos(List<Pratos> listaPratos){

        this.listPratos = listaPratos;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.pratos_detalhe, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        pratos = listPratos.get( position);

        holder.nomePrato.setText(pratos.getNome());
        holder.imagemPrato.setImageResource(pratos.getImagemPrato());

    }

    @Override
    public int getItemCount() {
        return listPratos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nomePrato;
        private ImageView imagemPrato;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomePrato = itemView.findViewById(R.id.pratoNome);
            imagemPrato =  itemView.findViewById(R.id.pratoImagem);
        }
    }
}
