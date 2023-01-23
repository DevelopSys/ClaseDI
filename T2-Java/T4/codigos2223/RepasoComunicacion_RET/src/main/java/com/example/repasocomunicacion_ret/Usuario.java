package com.example.repasocomunicacion_ret;

public class Usuario {

    private int id;
    private String nombre, correo, dni;
    private int telefono;

    public Usuario(int id, String nombre, String correo, String dni, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
