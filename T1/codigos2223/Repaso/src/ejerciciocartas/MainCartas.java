package ejerciciocartas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainCartas {

    public static void main(String[] args) {


        ArrayList<Carta> baraja = new MainCartas().rellenarBaraja();
        /*for (Carta carta: baraja) {
            carta.mostrarDatos();
        }*/
        //[]
        Jugador jugador1 = new Jugador();
        //[]
        Jugador jugador2 = new Jugador();

        // repartir a cada jugador
        for (int i = 0; i < 2; i++) {
            System.out.println("Repartiendo al J"+(i+1));
            // repartiendo 10 cartas al j que le toque
            for (int j = 0; j < 10; j++) {
                if (i==0){
                    // J1
                    jugador1.obtenerCarta(baraja.get(0));
                } else {
                    // J2
                    jugador2.obtenerCarta(baraja.get(0));
                }
                baraja.remove(0);
            }
        }

        System.out.println("Cartas del j1");
        jugador1.mostrarCartas();

        System.out.println("Cartas del j2");
        jugador2.mostrarCartas();

        int descartar = 2;
        // 1,4
        int[] posicionesDescarte = new int[]{1,4};

        Carta[] nuevas = new Carta[]{baraja.get(0),baraja.get(1)};
        jugador1.descartar(posicionesDescarte,nuevas);

    }

    public ArrayList<Carta> rellenarBaraja(){
        // C , P , T, R
        // 1-13
        ArrayList<Carta> baraja = new ArrayList<>();
        char[] palos = new char[]{'C' , 'P' , 'T', 'R'};
        for (int i = 0; i < palos.length; i++) {
            for (int j = 1; j < 14; j++) {
                baraja.add(new Carta(j,palos[i]));
            }
        }

        Collections.shuffle(baraja);
        return baraja;
    }
}
