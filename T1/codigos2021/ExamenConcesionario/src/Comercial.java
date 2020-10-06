public class Comercial extends Coche {

    private int capacidad;


    public Comercial(String modelo, String matricula, double precio, int capacidad) {
        super(modelo, matricula, precio);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Comercial{" +
                "capacidad=" + capacidad +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precio=" + precio +
                '}';
    }
}
