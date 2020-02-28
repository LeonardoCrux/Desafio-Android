package com.example.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurante implements Parcelable {
    private String nome, endereco, horario;
    private int imagem;


    public Restaurante(String nome, String endereco, int imagem, String horario) {
        this.nome = nome;
        this.endereco = endereco;
        this.imagem = imagem;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
