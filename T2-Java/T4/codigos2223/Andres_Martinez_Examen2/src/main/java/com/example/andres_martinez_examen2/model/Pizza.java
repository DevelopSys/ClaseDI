package com.example.andres_martinez_examen2.model;

public class Pizza {

    private String nombre;
    private double precio;

    public Pizza(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    void mostrarDatos(){
        System.out.println("Pizza "+this.nombre+".");
        System.out.println("Precio: "+this.precio);
    }
}
