package model;

import java.util.Comparator;

public class Encargo {

    private int id;
    private String titulo;
    private boolean realizado;

    public Encargo() {
    }

    public Encargo(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        // realizado = false;
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

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    @Override
    public String toString() {
        return "Encargo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", realizado=" + realizado +
                '}';
    }
}
