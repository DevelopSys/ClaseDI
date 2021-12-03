package com.example.tablas;

public class Pelicula {

    private int id;
    private String titulo, idioma, imagen, descripcion;
    private double popularidad;

    public Pelicula(int id, String titulo, String idioma, String imagen, String descripcion, double popularidad) {
        this.id = id;
        this.titulo = titulo;
        this.idioma = idioma;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.popularidad = popularidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }
}
