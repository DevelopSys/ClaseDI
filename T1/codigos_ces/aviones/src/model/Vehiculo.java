package model;

abstract public class Vehiculo {

    private String modelo, matricula;

    public Vehiculo() {
    }

    public Vehiculo(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void mostrarDatos(){
        System.out.println("modelo = " + modelo);
        System.out.println("matricula = " + matricula);
    }
}
