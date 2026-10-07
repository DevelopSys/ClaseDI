package model;

public class Accion extends Juego implements Descargable {

    private int violencia;
    private boolean multijugador;

    public Accion() {

    }

    public Accion(int anio, int tamanio, String titulo, String desarrollador, double precio, Clasificacion clasificacion, int violencia, boolean multijugador) {
        super(anio, tamanio, titulo, desarrollador, precio, clasificacion);
        this.violencia = violencia;
        this.multijugador = multijugador;
    }

    @Override
    void calcularPrecio() {
        if (violencia > 3) {
            setPrecio(getPrecio() * 0.05);
        }

        if (multijugador) {
            setPrecio(getPrecio() * 0.1);
        }
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("violencia = " + violencia);
        System.out.println("multijugador = " + multijugador);
    }

    public int getViolencia() {
        return violencia;
    }

    public void setViolencia(int violencia) {
        this.violencia = violencia;
    }

    public boolean isMultijugador() {
        return multijugador;
    }

    public void setMultijugador(boolean multijugador) {
        this.multijugador = multijugador;
    }

    @Override
    public void calcularDescarga(double velocidad) {
        System.out.println("Vas a tardar en descargar el juego " + velocidad/getTamanio());
    }

    @Override
    public void getTamanioGB() {
        System.out.println("El tamaño en gb es de  " + (getTamanio() / 1024) * 2);
    }
}
