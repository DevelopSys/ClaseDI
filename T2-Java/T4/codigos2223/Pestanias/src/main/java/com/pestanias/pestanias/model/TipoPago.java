package com.pestanias.pestanias.model;

public class TipoPago {

    private String nombre, descripcion;
    private int comision;

    public TipoPago(String nombre, String descripcion, int comision) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.comision = comision;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }
}
