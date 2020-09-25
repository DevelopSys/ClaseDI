package coches;

import java.util.Collection;
import java.util.Collections;

public class Entrada {

    public static void main(String[] args) {
        Garaje garaje= new Garaje();
        Coche focus = new Coche("Ford","Focus",150);
        Coche ibiza = new Coche("Seat","Ibiza",100);



        garaje.aceptarCoche(focus,"aceite");

        garaje.devolverCoche();

        garaje.aceptarCoche(ibiza,"aceite");

        garaje.devolverCoche();

        garaje.aceptarCoche(focus,"aceite");

        garaje.devolverCoche();

        garaje.aceptarCoche(ibiza,"chapa");

        garaje.devolverCoche();

        System.out.println(ibiza.toString());
        System.out.println(focus.toString());

    }
}
