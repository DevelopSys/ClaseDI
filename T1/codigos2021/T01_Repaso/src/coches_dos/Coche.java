package coches_dos;

public class Coche {

    private Motor motor;
    private String marca, modelo;
    private double averias;

    public Coche(String marca, String modelo, int cv) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = new Motor(cv);
    }

    public void incrementarAveria() {
        averias += Math.random() * 50;
    }

    public Motor getMotor() {
        return motor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getAverias() {
        return averias;
    }

    @Override
    public String toString() {
        return String.format("Coche:%s Modelo:%s Aceite:%d%n"
                , getMarca(), getModelo(), getMotor().getLitrosAceite());
    }
}
