package model;

abstract public class Videojuego {

    private int id;
    private String titulo, desarrollador;
    private int anioLanamiento;
    private double precio, tamanioJuego;
    private String clasificacionEdad;

    public Videojuego() {
    }

    public Videojuego(int id, String titulo, String desarrollador, int anioLanamiento, double precio, double tamanioJuego, String clasificacionEdad) {
        this.id = id;
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.anioLanamiento = anioLanamiento;
        this.precio = precio;
        this.tamanioJuego = tamanioJuego;
        this.clasificacionEdad = clasificacionEdad;
    }

    abstract public double calcularPrecioFinal();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public int getAnioLanamiento() {
        return anioLanamiento;
    }

    public void setAnioLanamiento(int anioLanamiento) {
        this.anioLanamiento = anioLanamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTamanioJuego() {
        return tamanioJuego;
    }

    public void setTamanioJuego(double tamanioJuego) {
        this.tamanioJuego = tamanioJuego;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", anioLanamiento=" + anioLanamiento +
                ", precio=" + precio +
                ", clasificacionEdad='" + clasificacionEdad + '\'' +
                '}';
    }
}
