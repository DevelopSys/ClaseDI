import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Entrada {

    /*
    * Realiza un programa que escoja al azar 10 cartas de la baraja española (10 objetos de la clase
    * Carta donde cada uno tiene valor y palo). Emplea un objeto de la clase ArrayList para almacenarlas
    * y asegúrate de que no se repite ninguna.
    * */
    public static void main(String[] args) {

        ArrayList<Carta> cartas = new ArrayList();
        String[] palos = {"Oros","Copas","Bastos","Espadas"};

        for(int i=0;i<10;i++){
            int posicionPalo = (int)(Math.random()*4);
            //System.out.println(posicionPalo);
            Carta generada = new Carta((int)(Math.random()*10),palos[posicionPalo]);
            boolean encontrada = false;

            for (Carta carta:cartas) {
                if (carta.equals(generada)){
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada){
                cartas.add(generada);
            }

        }

        for (Carta item:cartas) {
            System.out.println(item);
        }




    }
}
