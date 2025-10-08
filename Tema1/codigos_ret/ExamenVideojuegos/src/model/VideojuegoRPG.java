package model;

public class VideojuegoRPG extends Videojuego{

    private boolean mundoAbierto;
    private int horasHistoria;

    public VideojuegoRPG() {
    }

    public VideojuegoRPG(String titulo, String autor, int anio, double precio, ClasificacionEdad calificacionEdad, boolean mundoAbierto, int horasHistoria) {
        super(titulo, autor, anio, precio, calificacionEdad);
        this.mundoAbierto = mundoAbierto;
        this.horasHistoria = horasHistoria;
    }

    @Override
    public double calcularPrecioFinal() {
        double incremento = 0.0;
        if (mundoAbierto){
            incremento +=0.15;
        }
        incremento += (horasHistoria/10)*0.02;
        return getPrecio()*(1+incremento);
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
    public String toString() {
        return super.toString() + "VideojuegoRPG{" +
                "mundoAbierto=" + mundoAbierto +
                ", horasHistoria=" + horasHistoria +
                '}';
    }
}
