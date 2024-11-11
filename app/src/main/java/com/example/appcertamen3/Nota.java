package com.example.appcertamen3;

public class Nota {
    private String titulo;
    private String cuerpo;

    //Constructor

    public Nota(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    //Getters
    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }
}
