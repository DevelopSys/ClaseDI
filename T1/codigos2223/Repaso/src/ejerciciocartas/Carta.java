package ejerciciocartas;

public class Carta {

    private char palo;
    private int valor;

    public Carta (int valor, char palo){
        this.valor = valor;
        this.palo = palo;
    }

    public void mostrarDatos(){
        System.out.print(getValor()+""+getPalo()+", ");
    }

    public char getPalo() {
        return palo;
    }

    public void setPalo(char palo) {
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
