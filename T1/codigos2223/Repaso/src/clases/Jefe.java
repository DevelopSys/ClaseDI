package clases;

import interfaces.Votante;

public final class Jefe extends Trabajador implements Votante {

    private char nivelResponsavilidad;

    public Jefe(String nombre, String apellido, String dni, int NSS, char nivelResponsavilidad) {
        super(nombre, apellido, dni, NSS);
        this.nivelResponsavilidad = nivelResponsavilidad;
    }

    public char getNivelResponsavilidad() {
        return nivelResponsavilidad;
    }

    public void setNivelResponsavilidad(char nivelResponsavilidad) {
        this.nivelResponsavilidad = nivelResponsavilidad;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Nivel Responsavilidad: " + nivelResponsavilidad);
    }

    @Override
    public void calcularJubilacion() {
        System.out.println("Calculando Jubilacion del Jefe... ");

        double jubilacion = 0.0;

        switch (nivelResponsavilidad) {

            case 'A':
                jubilacion = 2000;

            case 'B':
                jubilacion = 1500;

            case 'C':
                jubilacion = 1250;
        }

        System.out.println("Jubilacion resultante ="+jubilacion);
    }

    @Override
    public int votar(int voto) {
        return voto/3;
    }
}
