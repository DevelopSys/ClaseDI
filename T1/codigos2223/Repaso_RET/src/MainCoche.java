import Model.Coche;

import java.util.ArrayList;

public class MainCoche {
    public static void main(String[] args) {
        int edad =0;
        String nombre = "Andrés";
        Coche coche1 = new Coche("Mercedes","C220");
        Coche coche2 = new Coche("Mercedes","C300",300,3.0);
        Coche coche3 = new Coche("A5","Audi",200, 5.5);
        Coche coche4 = new Coche("A3","audi",150,4.0);

        ArrayList<Coche> listaCoches = new ArrayList();

        listaCoches.add(coche1);
        listaCoches.add(coche2);
        listaCoches.add(coche3);
        listaCoches.add(coche4);

        //Media de CV e los coches registrados

        double total=0;

        for (Coche coche : listaCoches) {
            total+= coche.getCv();
        }

        total/=listaCoches.size();

        System.out.println("La media de los caballos de todos los coches en el concecionario es "+total);

       /* coche1.setCv(175);

        coche1.acelerarCoche(100);
        coche2.acelerarCoche(100);
        coche2.acelerarCoche(20);
        coche1.acelerarCoche(50);
        System.out.println(coche1);
        System.out.println(coche2);

        if(!coche1.decelerar(190));
            System.out.println("Ha ocurrido algo, frenazo ne seco");

        */
    }
}
