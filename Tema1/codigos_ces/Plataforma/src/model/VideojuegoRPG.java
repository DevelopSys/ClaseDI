package model;

public class VideojuegoRPG extends Videojuego implements Descargable{
    private boolean mundoAbierto;
    private int horasHistoria;

    public VideojuegoRPG() {
    }

    public VideojuegoRPG(int id, String titulo, String desarrollador, int anioLanamiento, double precio, double tamanioJuego, String clasificacionEdad, boolean mundoAbierto, int horasHistoria) {
        super(id, titulo, desarrollador, anioLanamiento, precio, tamanioJuego, clasificacionEdad);
        this.mundoAbierto = mundoAbierto;
        this.horasHistoria = horasHistoria;
    }

    @Override
    public double calcularPrecioFinal() {
        if (mundoAbierto){
            setPrecio(getPrecio()+getPrecio()*0.15);
        }

        double incremento = 0.02*(double) horasHistoria/10;
        setPrecio(getPrecio()+getPrecio()*incremento);
        return getPrecio();
    }

    public boolean isMundoAbierto() {
        return mundoAbierto;
    }

    public void setMundoAbierto(boolean mundoAbierto) {
        this.mundoAbierto = mundoAbierto;
    }

    public int getHorasHistoria() {
        return horasHistoria;
    }

    public void setHorasHistoria(int horasHistoria) {
        this.horasHistoria = horasHistoria;
    }

    @Override
    public int calcularTiempoDescarga(double velocidadInternet) {
        return (int)velocidadInternet;
    }

    @Override
    public double obtenerTamañoGB() {
        return getTamanioJuego();
    }
}
