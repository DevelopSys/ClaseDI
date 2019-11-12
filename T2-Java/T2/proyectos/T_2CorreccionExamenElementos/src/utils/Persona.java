package utils;

public class Persona {

    String nombre, dni;
    int nDi, nPmdm, nPsp, nAd;
    double media;

    public Persona(String nombre, String dni, int nDi, int nPmdm, int nPsp, int nAd) {
        this.nombre = nombre;
        this.dni = dni;
        this.nDi = nDi;
        this.nPmdm = nPmdm;
        this.nPsp = nPsp;
        this.nAd = nAd;
        this.media = (double) (nDi+nPmdm+nPsp+nAd)/(double)4;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getnDi() {
        return nDi;
    }

    public int getnPmdm() {
        return nPmdm;
    }

    public int getnPsp() {
        return nPsp;
    }

    public int getnAd() {
        return nAd;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", getNombre(),getDni());
    }
}
