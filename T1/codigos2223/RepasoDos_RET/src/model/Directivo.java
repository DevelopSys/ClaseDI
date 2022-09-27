package model;

public class Directivo extends Persona implements Votante{

    private double porcetAcciones, beneficios;

    public Directivo(String nombre, String apellido, String dni,
                     double porcetAcciones, double beneficios) {
        super(nombre, apellido, dni);
        this.porcetAcciones = porcetAcciones;
        this.beneficios = beneficios;
    }

    public double getPorcetAcciones() {
        return porcetAcciones;
    }

    public void setPorcetAcciones(double porcetAcciones) {
        this.porcetAcciones = porcetAcciones;
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public int votar(int voto) {
        return voto*2;
    }
}
