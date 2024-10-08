package model;

abstract public class Vehiculo {

    private String matricula;
    private String marca;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }

    public void mostrarDatos(){
        System.out.println("matricula = " + matricula);
        System.out.println("marca = " + marca);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
