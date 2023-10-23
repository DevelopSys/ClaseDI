package com.example.t2_botones.model;

public class MetodoPago {
    private int id;
    private String descipcion;
    private String[] caracteristicas;
    private double comisiones;

    public MetodoPago(int id, String descipcion, String[] caracteristicas, double comisiones) {
        this.id = id;
        this.descipcion = descipcion;
        this.caracteristicas = caracteristicas;
        this.comisiones = comisiones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String[] getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String[] caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getComisiones() {
        return comisiones;
    }

    public void setComisiones(double comisiones) {
        this.comisiones = comisiones;
    }
}
