package utils;

public class Coche {

    int id;
    String modelo;
    String matricula;
    int cv, anio;

    public Coche(int id, String modelo, String matricula, int cv, int anio) {
        this.id = id;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
        this.anio = anio;
    }

    public Coche(String modelo, String matricula, int cv, int anio) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getCv() {
        return cv;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return getMatricula();
    }
}
