package model;

public class Estrategia extends Juego {

    private int complicacion, duracion;

    public Estrategia() {

    }

    public Estrategia(int anio, int tamanio, String titulo, String desarrollador, double precio, Clasificacion clasificacion, int complicacion, int duracion) {
        super(anio, tamanio, titulo, desarrollador, precio, clasificacion);
        this.complicacion = complicacion;
        this.duracion = duracion;
    }

    @Override
    void calcularPrecio() {
        setPrecio(getPrecio()*1.03);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("complicacion = " + complicacion);
        System.out.println("duracion = " + duracion);
    }
}
