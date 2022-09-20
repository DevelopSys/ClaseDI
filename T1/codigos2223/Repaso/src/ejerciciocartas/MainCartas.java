package ejerciciocartas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainCartas {

    public static void main(String[] args) {
        ArrayList<Carta> baraja = new ArrayList<>();
        baraja.add(new Carta(1,"C"));
        baraja.add(new Carta(6,"C"));
        baraja.add(new Carta(9,"T"));
        baraja.add(new Carta(12,"R"));
        baraja.add(new Carta(3,"P"));

        System.out.println("Antes de ordenar");
        for ( Carta carta : baraja ) {
            carta.mostrarDatos();
        }

        System.out.println("Despues de ordenar");
        Collections.sort(baraja, new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.getValor()> o2.getValor()) {
                    if (o1.getPalo().equalsIgnoreCase(o2.getPalo()))
                    return -1;
                }
                else {
                    return 0;
                }
            };
        });
        for ( Carta carta : baraja ) {
            carta.mostrarDatos();
        }

    }
}
