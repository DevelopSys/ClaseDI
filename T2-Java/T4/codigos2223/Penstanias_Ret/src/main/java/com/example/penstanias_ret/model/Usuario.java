package com.example.penstanias_ret.model;

public class Usuario {

    private String nombre, apellido, correo;
    private int id;

    public Usuario(String nombre, String apellido, String correo, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.id = id;
    }

    public void mostrarDatos(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("Correo: "+ correo);
        System.out.println("Id: "+id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id +" - "+nombre;
    }
}
