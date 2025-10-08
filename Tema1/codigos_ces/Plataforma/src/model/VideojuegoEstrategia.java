package model;

public class VideojuegoEstrategia extends Videojuego implements Descargable{
    private int complejidad, duracion;

    public VideojuegoEstrategia() {
    }

    public VideojuegoEstrategia(int id, String titulo, String desarrollador, int anioLanamiento, double precio, double tamanioJuego, String clasificacionEdad, int complejidad, int duracion) {
        super(id, titulo, desarrollador, anioLanamiento, precio, tamanioJuego, clasificacionEdad);
        this.complejidad = complejidad;
        this.duracion = duracion;
    }

    @Override
    public double calcularPrecioFinal() {
        // debe añadir un 3%
        double incremento = 0.03 *complejidad;
        setPrecio(getPrecio()+getPrecio()*incremento);
        return getPrecio();
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public int calcularTiempoDescarga(double velocidadInternet) {
        return (int)(0.75*velocidadInternet);
    }

    @Override
    public double obtenerTamañoGB() {
        return getTamanioJuego();
    }
}
