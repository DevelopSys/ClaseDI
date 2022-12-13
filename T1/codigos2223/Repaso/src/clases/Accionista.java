package clases;

import interfaces.Votante;

public class Accionista extends Persona implements Votante {

    private double porcentAciones;

    public Accionista(String nombre, String apellidos, String dni, double porcentAciones, double beneficios) {
        super(nombre, apellidos, dni);
        this.porcentAciones = porcentAciones;
    }

    public double getPorcentAciones() {
        return porcentAciones;
    }

    public void setPorcentAciones(double porcentAciones) {
        this.porcentAciones = porcentAciones;
    }

    @Override
    public int votar(int voto) {
        return voto;
    }
}
