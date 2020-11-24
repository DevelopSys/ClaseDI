package sample.utils;

public class Equipo {

    String nombre, anio, escudo;

    public Equipo(String nombre, String anio, String escudo) {
        this.nombre = nombre;
        this.anio = anio;
        this.escudo = escudo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", anio='" + anio + '\'' +
                '}';
    }
}
