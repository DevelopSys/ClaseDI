package model;

public class Tractor extends Vehiculo{

    private int capacidadMaletas;

    public Tractor() {
    }

    public Tractor(String matricula, String marca, int capacidadMaletas) {
        super(matricula, marca);
        this.capacidadMaletas = capacidadMaletas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("capacidadMaletas = " + capacidadMaletas);
    }

    public int getCapacidadMaletas() {
        return capacidadMaletas;
    }

    public void setCapacidadMaletas(int capacidadMaletas) {
        this.capacidadMaletas = capacidadMaletas;
    }
}
