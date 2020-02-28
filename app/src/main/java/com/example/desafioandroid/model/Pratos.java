package com.example.desafioandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pratos implements Parcelable {
    private String nome;
    private int imagemPrato;
    private String descricao;

    public Pratos (){

    }

    public Pratos(String nome, int imagemPrato, String descricao) {
        this.nome = nome;
        this.imagemPrato = imagemPrato;
        this.descricao = descricao;
    }

    protected Pratos(Parcel in) {
        nome = in.readString();
        imagemPrato = in.readInt();
        descricao = in.readString();
    }

    public static final Creator<Pratos> CREATOR = new Creator<Pratos>() {
        @Override
        public Pratos createFromParcel(Parcel in) {
            return new Pratos(in);
        }

        @Override
        public Pratos[] newArray(int size) {
            return new Pratos[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagemPrato() {
        return imagemPrato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagemPrato(int imagemPrato) {
        this.imagemPrato = imagemPrato;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(imagemPrato);
        dest.writeString(descricao);
    }
}
