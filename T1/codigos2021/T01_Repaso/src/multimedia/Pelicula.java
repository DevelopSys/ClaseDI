package multimedia;

public class Pelicula extends Multimedia {

    private String[] actores;
    private String pais;
    private double duracion;

    public Pelicula(String titulo, String autor, int anio, int codigo, String[] actores,String pais, double duracion) {
        super(titulo, autor, anio, codigo);
        this.actores = actores;
        this.pais = pais;
        this.duracion = duracion;
    }

    public String[] getActores() {
        return actores;
    }

    public void setActores(String[] actores) {
        this.actores = actores;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return super.toString() + "actores: "+actores;
    }
}
