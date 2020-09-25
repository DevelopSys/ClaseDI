package coches;

public class Coche {

    private Motor motor;
    private String marca, modelo;
    private double averiasAcumuladas;

    public Coche(String m, String mo, int cv){
        this.marca = m;
        this.modelo = mo;
        this.motor = new Motor(cv);
    }

    public void acumularAverias(){
        //this.averiasAcumuladas = this.averiasAcumuladas + Math.random() *100;
        this.averiasAcumuladas += (int)(Math.random() *100);
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

    public double getAveriasAcumuladas() {
        return averiasAcumuladas;
    }

    @Override
    public String toString() {
        return String.format("Marca: %s Modelo: %s Aceite: %d Averias: %.2f",
                getMarca(),getModelo(), getMotor().getLitrosAceite(),getAveriasAcumuladas());
    }
}
