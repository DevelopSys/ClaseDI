package utils;

public class Persona {

    String nombre, estado;

    public Persona(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
