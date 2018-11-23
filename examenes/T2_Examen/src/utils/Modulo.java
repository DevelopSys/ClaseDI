package utils;

import java.util.ArrayList;

public class Modulo {

    String nombre;
    ArrayList asignaturas;

    public Modulo(String nombre, ArrayList asignaturas) {
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList getAsignaturas() {
        return asignaturas;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
