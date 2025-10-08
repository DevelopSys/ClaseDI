package model;

public class VideojuegoEstrategia extends Videojuego{
    private int nComplejidad, duracionPartida;

    public VideojuegoEstrategia() {
    }

    public VideojuegoEstrategia(String titulo, String autor, int anio, double precio, ClasificacionEdad calificacionEdad, int nComplejidad, int duracionPartida) {
        super(titulo, autor, anio, precio, calificacionEdad);
        this.nComplejidad = nComplejidad;
        this.duracionPartida = duracionPartida;
    }

    @Override
    public double calcularPrecioFinal() {
        double incremento = 0.0;
        incremento = 0.03*nComplejidad;
        return getPrecio()*1+incremento;
    }

    public int getnComplejidad() {
        return nComplejidad;
    }

    public void setnComplejidad(int nComplejidad) {
        this.nComplejidad = nComplejidad;
    }

    public int getDuracionPartida() {
        return duracionPartida;
    }

    public void setDuracionPartida(int duracionPartida) {
        this.duracionPartida = duracionPartida;
    }

    @Override
    public String toString() {
        return super.toString() + "VideojuegoEstrategia{" +
                "nComplejidad=" + nComplejidad +
                ", duracionPartida=" + duracionPartida +
                '}';
    }
}
