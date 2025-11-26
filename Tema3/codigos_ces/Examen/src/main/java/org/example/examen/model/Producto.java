package org.example.examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private String categoria;
    private String descripcion;

    public Producto(String nombre, double precio, String categoria, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }
}
