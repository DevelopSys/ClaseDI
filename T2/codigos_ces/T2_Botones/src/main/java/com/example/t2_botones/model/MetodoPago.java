package com.example.t2_botones.model;


public class MetodoPago {

    private int id;
    private String descripcion;
    private String caracteristica;


    public MetodoPago() {
    }

    public MetodoPago(int id, String descripcion, String caracteristica) {
        this.id = id;
        this.descripcion = descripcion;
        this.caracteristica = caracteristica;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCaracteristica() {
        return caracteristica;
    }
}
