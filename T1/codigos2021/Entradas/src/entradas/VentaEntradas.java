package entradas;

public class VentaEntradas {

    private int numeroEntradas, entradasGenerales, entradasComVen, entradasVip;

    public VentaEntradas(){
        numeroEntradas=1225;
        entradasGenerales=1000;
        entradasComVen=200;
        entradasVip=25;
    }

    public void vendeEntrada(int tipo, int cantidad){
        if(tipo==1){
            if(entradasGenerales-cantidad < 0){
                System.out.println("No hay entradas disponibles");
            } else {
                System.out.println("Compra completada");
                entradasGenerales -= cantidad;
            }
        }else if(tipo==2){
            if(entradasComVen==0){
                System.out.println("No hay entradas disponibles");
            } else {
                System.out.println("Compra completada");
                entradasComVen -= cantidad;
            }
        }else if(tipo==3){
            if(entradasVip==0){
                System.out.println("No hay entradas disponibles");
            } else {
                System.out.println("Compra completada");
                entradasVip -= cantidad;
            }
        }

        numeroEntradas = entradasComVen+entradasVip+entradasGenerales;
        //numeroEntradas -= cantidad;
    }

    public int getNumeroEntradas() {
        return numeroEntradas;
    }

    public void setNumeroEntradas(int numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
    }

    public int getEntradasGenerales() {
        return entradasGenerales;
    }

    public void setEntradasGenerales(int entradasGenerales) {
        this.entradasGenerales = entradasGenerales;
    }

    public int getEntradasComVen() {
        return entradasComVen;
    }

    public void setEntradasComVen(int entradasComVen) {
        this.entradasComVen = entradasComVen;
    }

    public int getEntradasVip() {
        return entradasVip;
    }

    public void setEntradasVip(int entradasVip) {
        this.entradasVip = entradasVip;
    }
}
