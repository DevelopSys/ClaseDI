package model;

public class Audio extends Multimedia {

    private int duracion;
    private String soporte;

    public Audio() {
    }

    public Audio(int id, String titulo, String autor, int tamanio,
                 String formato, int duracion, String soporte) {
        super(id, titulo, autor, tamanio, formato);
        this.duracion = duracion;
        this.soporte = soporte;
    }

    @Override
    public int calificar() {
        if (getTamanio() < 100 && duracion < 100)
            return 1;
        else if (getTamanio() < 200 && duracion < 200)
            return 2;
        return 3;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("duracion = " + duracion);
        System.out.println("soporte = " + soporte);
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }
}
