package ejerciciocartas;

public class Carta {

    private String palo;
    private int valor;

    public Carta (int valor, String palo){
        this.valor = valor;
        this.palo = palo;
    }

    public void mostrarDatos(){
        System.out.println(getValor()+getPalo());
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
