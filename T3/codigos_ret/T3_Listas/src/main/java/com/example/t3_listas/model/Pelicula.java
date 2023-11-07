package com.example.t3_listas.model;

public class Pelicula {

    private String titulo;
    private String genero;
    private double calificaion;
    private int anio;

    public Pelicula(String titulo, String genero, double calificaion, int anio) {
        this.titulo = titulo;
        this.genero = genero;
        this.calificaion = calificaion;
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getCalificaion() {
        return calificaion;
    }

    public void setCalificaion(double calificaion) {
        this.calificaion = calificaion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
