package clases;

import interfaces.Votante;

public class Directivo extends Persona implements Votante {

    private double porcentAcciones, beneficios;

    public Directivo(String nombre, String apellidos, String dni, double porcentAcciones, double beneficios) {
        super(nombre, apellidos, dni);
        this.porcentAcciones = porcentAcciones;
        this.beneficios = beneficios;
    }

    public double getPorcentAcciones() {
        return porcentAcciones;
    }

    public void setPorcentAcciones(double porcentAcciones) {
        this.porcentAcciones = porcentAcciones;
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public int votar(int voto) {
        return voto * 2;
    }
}
