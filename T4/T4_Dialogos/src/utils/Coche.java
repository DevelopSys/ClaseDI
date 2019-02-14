package utils;

public class Coche {

    int id;
    String modelo;
    int matricula, cv, anio;

    public Coche(int id, String modelo, int matricula, int cv, int anio) {
        this.id = id;
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

    public int getMatricula() {
        return matricula;
    }

    public int getCv() {
        return cv;
    }

    public int getAnio() {
        return anio;
    }
}
