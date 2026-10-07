package model;

import java.io.Serializable;

abstract public class Juego implements Serializable {

    private static final Long serialVersionUID = 1234L;
    private int id, anio, tamanio;
    private String titulo, desarrollador;
    private double precio;
    private Clasificacion clasificacion;

    public Juego() {
    }

    public Juego(int anio, int tamanio, String titulo, String desarrollador, double precio, Clasificacion clasificacion) {
        this.anio = anio;
        this.tamanio = tamanio;
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.precio = precio;
        this.clasificacion = clasificacion;
    }

    abstract public void calcularPrecio();

    public void mostrarDatos() {
        System.out.println("id = " + id);
        System.out.println("anio = " + anio);
        System.out.println("tamanio = " + tamanio);
        System.out.println("titulo = " + titulo);
        System.out.println("desarrollador = " + desarrollador);
        System.out.println("precio = " + precio);
        System.out.println("clasificacion = " + clasificacion);
    }

    public String toCSV() {
        return String.format("%d,%s,%s,%s", id, titulo, desarrollador, clasificacion.name());
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
}
