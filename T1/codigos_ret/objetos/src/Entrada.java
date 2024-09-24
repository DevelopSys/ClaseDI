import controller.Garaje;
import model.Coche;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        Coche coche1 = new Coche("1234A","Ford","Fista",150);
        Coche coche2 = new Coche("2345A","Ford","Fista",150);
        Coche coche3 = new Coche("3456A","Ford","Fista",150);
        Coche coche4 = new Coche("4567A","Ford","Fista",150);
        ArrayList<Coche> garaje = new ArrayList<>();
        garaje.add(coche1);
        garaje.add(coche2);
        garaje.add(coche3);
        garaje.add(new Coche("4567A","Ford","Fista",150));

        coche1.setArreglos((int)(Math.random() *401)+100);
        coche4.setArreglos((int)(Math.random() *401)+100);


        // garaje.get(0).setArreglos((int)(Math.random() *401)+100);
        // garaje.get(3).setArreglos((int)(Math.random() *401)+100);

        for ( Coche coche : garaje ) {
            coche.mostrarDatos();
        }

    }
}
