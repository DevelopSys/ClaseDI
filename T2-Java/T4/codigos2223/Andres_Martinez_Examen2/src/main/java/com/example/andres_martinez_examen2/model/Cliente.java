package com.example.andres_martinez_examen2.model;

public class Cliente {

    private String Nombre;
    private String telefono;

    public Cliente(String nombre, String telefono) {
        Nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
