package model;

public class VideojuegoAccion extends Videojuego{

    private int nivelViolencia;
    private boolean multijugador;

    public VideojuegoAccion() {
    }

    public VideojuegoAccion(String titulo, String autor, int anio, double precio, ClasificacionEdad calificacionEdad, int nivelViolencia, boolean multijugador) {
        super(titulo, autor, anio, precio, calificacionEdad);
        this.nivelViolencia = nivelViolencia;
        this.multijugador = multijugador;
    }

    @Override
    public double calcularPrecioFinal() {
        // miltu +10%
        // por cada > 5

        double incremento =0.0;
        if (multijugador){
            incremento += 0.1;
        }
        if (nivelViolencia>3){
            incremento += 0.05;
        }

        return getPrecio()* 1+incremento;
    }

    public int getNivelViolencia() {
        return nivelViolencia;
    }

    public void setNivelViolencia(int nivelViolencia) {
        this.nivelViolencia = nivelViolencia;
    }

    public boolean isMultijugador() {
        return multijugador;
    }

    public void setMultijugador(boolean multijugador) {
        this.multijugador = multijugador;
    }

    @Override
    public String toString() {
        return super.toString() + "VideojuegoAccion{" +
                "nivelViolencia=" + nivelViolencia +
                ", multijugador=" + multijugador +
                '}';
    }
}
