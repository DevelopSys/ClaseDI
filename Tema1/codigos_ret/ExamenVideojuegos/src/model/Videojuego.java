package model;

abstract public class Videojuego {

    private String titulo, autor;
    private int anio;
    private double precio;
    private ClasificacionEdad calificacionEdad;


    public Videojuego() {
    }

    public Videojuego(String titulo, String autor, int anio, double precio, ClasificacionEdad calificacionEdad) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.precio = precio;
        this.calificacionEdad = calificacionEdad;
    }

    abstract public double calcularPrecioFinal();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ClasificacionEdad getCalificacionEdad() {
        return calificacionEdad;
    }

    public void setCalificacionEdad(ClasificacionEdad calificacionEdad) {
        this.calificacionEdad = calificacionEdad;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio=" + anio +
                ", precio=" + precio +
                ", calificacionEdad=" + calificacionEdad +
                '}';
    }
}
