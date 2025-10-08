package model;

public class VideojuegoAccion extends Videojuego implements Descargable{

    private int nivelViolencia;
    private boolean multijugador;

    public VideojuegoAccion() {
    }

    public VideojuegoAccion(int id, String titulo, String desarrollador, int anioLanamiento, double precio, double tamanioJuego, String clasificacionEdad, int nivelViolencia, boolean multijugador) {
        super(id, titulo, desarrollador, anioLanamiento, precio, tamanioJuego, clasificacionEdad);
        this.nivelViolencia = nivelViolencia;
        this.multijugador = multijugador;
    }

    @Override
    public double calcularPrecioFinal() {
        if (nivelViolencia>3){
            setPrecio(getPrecio()+getPrecio()*0.3);
        }
        if (multijugador){
            setPrecio(getPrecio()+getPrecio()*0.15);
        }
        return getPrecio();
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
    public int calcularTiempoDescarga(double velocidadInternet) {
        return (int)(velocidadInternet*0.5);
    }

    @Override
    public double obtenerTamañoGB() {
        return getTamanioJuego();
    }
}
