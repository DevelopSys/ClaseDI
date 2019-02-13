package utils;

public class Pelicula {

    int id;
    String titulo, genero, prota;
    int anio;


    public Pelicula(int id, String titulo, String genero, String prota, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.prota = prota;
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getProta() {
        return prota;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return getTitulo();
    }
}
