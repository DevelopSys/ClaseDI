import java.io.Serializable;
import java.util.ArrayList;

public abstract class Llamada implements Serializable {

    int nOrigen, nDestino, duracion;
    double coste;

    public Llamada(int nOrigen, int nDestino, int duracion) {
        this.nOrigen = nOrigen;
        this.nDestino = nDestino;
        this.duracion = duracion;
    }

    public abstract void caluclarCoste();

    public void mostrarDatos(){
        System.out.printf("Tipo de llamada %s %n",getClass().getName());
        System.out.printf("Número Origen %d %n",nOrigen);
        System.out.printf("Número Destino %d %n",nDestino);
        System.out.printf("Duración %d %n",duracion);
        System.out.printf("Coste %.2f %n",coste);
    }

    public int getnOrigen() {
        return nOrigen;
    }

    public void setnOrigen(int nOrigen) {
        this.nOrigen = nOrigen;
    }

    public int getnDestino() {
        return nDestino;
    }

    public void setnDestino(int nDestino) {
        this.nDestino = nDestino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }
}
