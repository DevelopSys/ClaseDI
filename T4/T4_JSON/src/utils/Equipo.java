package utils;

public class Equipo {

    String nombre, estadio, descripcion, url;

    public Equipo(String nombre, String estadio, String descripcion, String url) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.descripcion = descripcion;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
