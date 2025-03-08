package com.example.atividade_lanche02.entities;

public class Lanche {
    private String nome, img_url;
    private double preco;
    private int codigo;

    public Lanche(String nome, String img_url, double preco, int codigo) {
        this.nome = nome;
        this.img_url = img_url;
        this.preco = preco;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Lanche [nome=" + nome 
            + ", img_url=" + img_url 
            + ", preco=" + preco 
            + ", codigo=" + codigo + "]";
    }
    
}
