package com.example.t3_listas.model;

public class Usuario {

    private String nombre, pass, correo;

    public Usuario(String nombre, String pass, String correo) {
        this.nombre = nombre;
        this.pass = pass;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
