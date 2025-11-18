package org.example.examenpizzeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    public static int id;
    private String nombre;
    private Pizza pizza;
    private int precio;

    @Override
    public String toString() {
        return id + " "+nombre;
    }
}
