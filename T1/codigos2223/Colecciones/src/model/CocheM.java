package model;

public class CocheM {

    // VARIABLES - PROPIEDAD
    // protected --> herencia
    private String matricula;
    private String marca, modelo;
    private int velocidad, bastidor;
    private double km;

    // CONSTRUCTOR --> uno defecto hasta escribir uno
    public CocheM (String marca, String modelo, int bastidor){
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        // velocidad -> 0
        // matricula -> null
    }
    public CocheM (String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
        // velocidad -> 0
        // matricula -> null
        // bastidor -> 0
    }
    public CocheM (){}

    // METODOS

    public void acelerar(int velocidad){
        this.velocidad += velocidad;
        this.km +=velocidad;
    }
    public void decelerar (int velocidad){
        this.velocidad -= velocidad;
    }

    public void frenar(){
        System.out.println(velocidad);
        for (int i = velocidad; i > 0; i--) {
            i-=9;
            velocidad -=10;
            System.out.println("Reduciendo velocidad: "+velocidad);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // GETTER SETTER TOSTRING


    public String getMatricula() {

        return matricula.substring(0,4);
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidad=" + velocidad +
                ", km=" + km +
                '}';
    }
}

