package com.example.elementos.utils;

public class Pelicula {

    private String titulo, imagen, descripcion;
    private int id;

    public Pelicula(String titulo, String imagen, int id, String descripcion) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.id = id;
        this.descripcion = descripcion;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
