package model;

public class RPG extends Juego implements Descargable {

    private boolean mundoAbierto;
    private int nHoras;


    public RPG() {

    }

    public RPG(int anio, int tamanio, String titulo, String desarrollador, double precio, Clasificacion clasificacion, boolean mundoAbierto, int nHoras) {
        super(anio, tamanio, titulo, desarrollador, precio, clasificacion);
        this.mundoAbierto = mundoAbierto;
        this.nHoras = nHoras;
    }

    @Override
    void calcularPrecio() {

        if (mundoAbierto) {
            setPrecio(getPrecio() * 1.15);
        }

        setPrecio(getPrecio() * (0.02 * (nHoras / 10.0)));

    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("mundoAbierto = " + mundoAbierto);
        System.out.println("nHoras = " + nHoras);
    }

    @Override
    public void calcularDescarga(double velocidad) {
        System.out.println("Vas a tardar en descargar el juego " + velocidad/getTamanio());
    }

    @Override
    public void getTamanioGB() {
        System.out.println("El tamaño en gb es de  " + (getTamanio() / 1024)*3);
    }
}
