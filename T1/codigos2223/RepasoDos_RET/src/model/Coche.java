package model;

public class Coche {

    // cambio desde el IDE
    // propiedades --> private (public) "protected"--> ENCAPSULAMIENTO
    private String marca, modelo, bastidor;
    private int cv;
    private double cc;
    private int velocidad, km;

    // constructores() -> 1 () --> explicito si hay uno

    public Coche() {
    }

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Coche(String modelo, String marca, int cv, double cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.cc = cc;
    }

    public Coche(String marca, String modelo, String bastidor, int cv, double cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.cv = cv;
        this.cc = cc;
    }

    // métodos -- funcionalidades del objeto
    public void acelerarCoche (int velocidad){
        // si los cv son superiores a 150, incrementar en un 20%
        if (this.cv > 150){
            // 100 --- 100 = 100 + 100 +20
            this.velocidad = this.velocidad + velocidad + (int)(velocidad*0.2);
        } else {
            this.velocidad += velocidad;
        }
    }

    public boolean decelerar(int velocidad){
        // si pasan una v mayor de la actual pongo 0 y retorno false
        // en caso contrario hago la operacion y retorno true;
        if (this.velocidad<velocidad){
            this.velocidad = 0;
            return false;
        } else {
            this.velocidad -= velocidad;
            return true;
        }
    }

    // gettet setter
    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
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

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", bastidor='" + bastidor + '\'' +
                ", cv=" + cv +
                ", cc=" + cc +
                ", velocidad=" + velocidad +
                ", km=" + km +
                '}';
    }
}




