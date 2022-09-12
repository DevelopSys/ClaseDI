package coches;

import java.util.Calendar;

public class MainCoches {

    public static void main(String[] args) {
        Coche[] coches = new Coche[3];
        Coche cocheMercedes = new Coche("Mercedes","C220",200,2.500);
        Coche cocheMercedesDos = new Coche("Mercedes","C180",200,2.500);
        Coche cocheAudi = new Coche("Audi","A5",200,2.500);

        coches[0] = cocheMercedes;
        coches[1] = cocheMercedesDos;
        coches[2] = cocheAudi;


        //System.out.println(coches[1].getModelo()); // C180
        //coches[1].setModelo("C300");
        //System.out.println(coches[1].getModelo()); // C300

        for ( Coche item : coches ) {
            System.out.println(item);

        }

    }
}
