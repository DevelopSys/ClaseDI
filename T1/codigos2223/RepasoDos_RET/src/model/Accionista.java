package model;

public class Accionista extends Persona implements Votante{

    private double porcetAcciones;

    public Accionista(String nombre, String apellido, String dni,
                      double porcetAcciones) {
        super(nombre, apellido, dni);
        this.porcetAcciones = porcetAcciones;

    }

    public double getPorcetAcciones() {
        return porcetAcciones;
    }

    public void setPorcetAcciones(double porcetAcciones) {
        this.porcetAcciones = porcetAcciones;
    }

    @Override
    public int votar(int voto) {
        return voto;
    }
}
