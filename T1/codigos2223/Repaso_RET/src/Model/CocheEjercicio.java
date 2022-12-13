package Model;

public class CocheEjercicio {

    private String marca, modelo, matricula;
    private int cv, km;
    private double cc;
    private int velocidad;

    //Constructores


    public CocheEjercicio(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public CocheEjercicio(String modelo,String matricula, int cv) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.cv = cv;
    }

    public CocheEjercicio(String marca, String modelo, String matricula, int cv, double cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cv = cv;
        this.cc = cc;
    }

    public CocheEjercicio() {
        this.matricula  = "0000AAA";
        this.modelo     = "sin especificar";
    }


    //metodos -- funcionalidades del objeto
    public void acelerarCoche(int velocidad) {
        if (velocidad > 180) {System.out.println("La velocidad límite es de 180");
        velocidad = 180;
        } else this.velocidad = velocidad;

        int random = (int)(Math.random()*10);
        km += velocidad*(this.cv*random);
    }

    public void frenar(int velocidad) {
        if (this.velocidad < velocidad) {
            this.velocidad = 0;
            System.out.println("La velocidad introducida era mayor a la actual. Velocidad establecida a 0");
        } else {
            this.velocidad -= velocidad;
        }
    }
        public void parar(){
            this.velocidad = 0;
        }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
                ", matricula='" + matricula + '\'' +
                ", cv=" + cv +
                ", cc=" + cc +
                ", velocidad=" + velocidad +
                ", km=" + km +
                '}';
    }
}

