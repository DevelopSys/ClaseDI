import model.Coche;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int edad = 0;
        String nombre = "Borja"; // null
        



        // Coche[marca="M",modelo="C220",cv=0,cc=0.0,bastidor=null,vel=100,km=0]
        Coche coche1 = new Coche("Mercedes","C220");
        // Coche[marca="M",modelo="C300",cv=300,cc=3.0,bastidor=null,vel =120,km=0]
        Coche coche2 = new Coche("C300","Mercedes",300,3.0);
        Coche coche3 = new Coche("A5","Audi",200,2.5);
        Coche coche4 = new Coche("A3","Audi",150,2.0);

        ArrayList<Coche> listaCoches = new ArrayList();

        listaCoches.add(coche1);
        listaCoches.add(coche2);
        listaCoches.add(coche3);
        listaCoches.add(coche4);

        // media de CV de los coches que estan en el concesionario 10000000

        double media=0;
        for ( Coche coche : listaCoches ) {
            media += coche.getCv();
        }
        media /=listaCoches.size();
        System.out.println("La media de CV es: "+media);
        /*coche1.setCv(175);

        coche1.acelerarCoche(100);
        coche2.acelerarCoche(100);
        coche2.acelerarCoche(20);
        coche1.acelerarCoche(50);

        System.out.println(coche1);
        System.out.println(coche2);

        if(!coche1.decelerar(190)){
            System.out.println("Ha ocurrido algo, frenazo en seco");
        }
        System.out.println(coche1);*/
    }
}
