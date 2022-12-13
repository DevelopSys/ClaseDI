package Model;

public class Coche {

    private String marca, modelo, bastidor;
    private int cv;
    private double cc;
    private int velocidad, km;

    //Constructores


    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Coche(String marca, String modelo, int cv, double cc) {
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

    public Coche() {}


    //metodos -- funcionalidades del objeto
    public void acelerarCoche(int velocidad) {
        //si los cv son superiores a 150, incrementar en un 20%
        if (this.cv > 150) {
            this.velocidad = this.velocidad + velocidad + (int) (velocidad * .2);
        } else {
            this.velocidad += velocidad;
        }
    }

        public boolean decelerar(int velocidad) {
            if (this.velocidad < velocidad) {
                this.velocidad = 0;
                return false;
            } else {
                this.velocidad -= velocidad;
                return true;
            }
        }
    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public int getVelocidad() {
        return velocidad;
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

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    //setter -> Retorna valor
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //getter retorno valor del tipo concreto

    public String getMarca() {
        return marca;
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

