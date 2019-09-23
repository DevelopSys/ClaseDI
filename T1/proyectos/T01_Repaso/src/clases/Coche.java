package clases;

public class Coche {

    private String matricula, marca, modelo;
    private int cv, bastidor, velocidad;
    boolean aparcado;


    public Coche(String matricula, String marca, String modelo, int cv, int bastidor) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.bastidor = bastidor;
        this.velocidad = 0;
        this.aparcado = true;
    }

    public void acelerarCoche() {
        this.velocidad += 50;
    }

    public void acelerar(int velocidad) {
        this.velocidad += velocidad;
        //this.velocidad = this.velocidad +velocidad;
    }

    public void decelerar(int velocidad) {
        if (this.velocidad < velocidad) {
            this.velocidad = 0;
        } else {
            this.velocidad -= velocidad;
        }
    }

    public boolean estaParado(){
        if (this.velocidad <= 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isAparcado() {
        return aparcado;
    }

    public void setAparcado(boolean aparcado) {
        this.aparcado = aparcado;
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

    public int getBastidor() {
        return bastidor;
    }

    public void setBastidor(int bastidor) {
        this.bastidor = bastidor;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return String.format("Marca: %s Modelo: %s CV: %d Bastidor: %d Matricula: %s Velocidad: %d Estado: %b"
                , marca,modelo,cv,bastidor,matricula,velocidad,aparcado);
    }
}
