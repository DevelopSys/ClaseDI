package com.example.elementos.utils;

public class Pelicula {

    private String titulo, imagen;
    private int id;

    public Pelicula(String titulo, String imagen, int id) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
