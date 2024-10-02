package model;

public class Tractor extends Vehiculo{

    private int capacidadMaletas;

    public Tractor() {
    }

    public Tractor(String modelo, String matricula, int capacidadMaletas) {
        super(modelo, matricula);
        this.capacidadMaletas = capacidadMaletas;
    }

    public int getCapacidadMaletas() {
        return capacidadMaletas;
    }

    public void setCapacidadMaletas(int capacidadMaletas) {
        this.capacidadMaletas = capacidadMaletas;
    }
}
