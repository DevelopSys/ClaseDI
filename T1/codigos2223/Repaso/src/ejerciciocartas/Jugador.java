package ejerciciocartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jugador {

    private ArrayList<Carta> cartas;

    public Jugador() {
        this.cartas = new ArrayList<>() ;
    }

    public void mostrarCartas(){
        Collections.sort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.getValor()> o2.getValor()) return -1;
                else return 0;
            }
        });
        for ( Carta carta : cartas ) {
            carta.mostrarDatos();
        }
        System.out.println();
    }

    public void descartar(int[] posiciones, Carta[] cartasNuevas){
        for (int i = 0; i < posiciones.length; i++) {
            cartas.set(posiciones[i],cartasNuevas[i]);
            // cartas.add(cartasNuevas[i]);
        }

    }

    public void obtenerCarta(Carta carta){
        cartas.add(carta);
    }
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }


}
