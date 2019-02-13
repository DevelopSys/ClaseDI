package utils;

public class Serie {

    int id;
    String titulo, genero, cadena;
    int temporadas;

    public Serie(int id, String titulo, String genero, String cadena, int temporadas) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.cadena = cadena;
        this.temporadas = temporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getCadena() {
        return cadena;
    }

    @Override
    public String toString() {
        return getTitulo();
    }
}
