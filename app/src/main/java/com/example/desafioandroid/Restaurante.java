package com.example.desafioandroid;

public class Restaurante {
    private String nome;
    private String endereco;
    private int imagem;
    private String horario;


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
}
