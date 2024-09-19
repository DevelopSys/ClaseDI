package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class Entrada {
    public static void main(String[] args) {
        // [] -> 0 size
        /*ArrayList<String> listaCosas = new ArrayList<>();
        listaCosas.add("Alumno 1"); // ["Alumno 1"] ->size 1
        listaCosas.add("Alumno 2"); // ["Alumno 1","Alumno 2"] ->size 2
        System.out.println(listaCosas.get(0)); // Alumno 1
        listaCosas.add("Alumno 5");// ["Alumno 1","Alumno 2", "Alumno 5"] -> size 3
        System.out.println(listaCosas.get(listaCosas.size()-1)); // Alumno 2
        //listaCosas.remove("1"); // // ["Alumno 1","Alumno 5"] -> size 2
        listaCosas.remove(1); // // ["Alumno 1","Alumno 5"] -> size 2
        listaCosas.remove("Alumno 1"); // ["Alumno 5"] -> size 1
        //listaCosas.removeAll()
        listaCosas.clear(); // [] -> size 0
        // listaCosas.removeAll()
        /*listaCosas.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equalsIgnoreCase("Profesor");
            }
        });
        listaCosas.set(1,"Profesor 1");
        // listaCoasas[1] = Profesor
        for ( String item : listaCosas ) {
            System.out.println(item);
            if (item.contains("alumno")){

            }
        }

        for (int i = 0; i < listaCosas.size(); i++) {
            System.out.println(listaCosas.get(i));
        }*/

        // ejercicioTemperaturas();
        ejercicioGaraje();

    }

    // GESTIONAR TEMPERATURAS
    // introducir temperaturas (+ o -) hasta que se introduzca un 0

    // mostrar los extremos y la temperatura media

    public static void ejercicioTemperaturas(){
        ArrayList<Double> listadoTemperaturas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        double temperatura;
        double media = 0;
        do {
            System.out.println("Introduce temperatura");
            temperatura = scanner.nextDouble();
            listadoTemperaturas.add(temperatura);
            media +=temperatura;
        } while(temperatura!=0.0);

        // [4,7,1,-100,200,40]

        double max =listadoTemperaturas.getFirst(),  min=listadoTemperaturas.getFirst();
        /*for ( double item : listadoTemperaturas ) {
            if (item>max){
                max=item;
            }
            if(item<min) {
                min= item;
            }
        }*/
        Collections.sort(listadoTemperaturas);
        System.out.println("La temp min es "+listadoTemperaturas.getFirst());
        System.out.println("La temp max es "+listadoTemperaturas.getLast());
        System.out.println("La temperatura media es "+media/listadoTemperaturas.size());

    }
    public static void ejercicioGaraje(){
        // marca, modelo, cv, precio arreglos
        double arreglos = 0.0;
        Object[] coche = {"Ford","Focus",130,50.0};
        Object[] coche1 = {"Ford","Fiesta",100,100.0};

        ArrayList<Object[]> garaje = new ArrayList<>();
        garaje.add(coche);
        garaje.add(coche1);

        for ( Object[] item : garaje ) {
            System.out.println(item[1]);
            // if (item[3] instanceof Double){
                arreglos += (double)item[3];
            // }
        }
        System.out.println("El valor de todos los arreglos es: "+arreglos);

        // Crear un programa que permite gestionar un garaje.
        // Para ello el garaje admitira coches: matricula, marca, modelo, cv, coste
        // el garaje puede admitir solo 5 coches, si llega un 6 me da un error
        // cada vez que el coche entra en el garaje, su arrego es un aleatorio entre
        // 100 - 500
        // la funcionalidad se realiza sobre un menu
        // 1 - Agregar coche: pido los datos.
        // NO SE PUEDEN AGREGAR COCHES CON LA MISMA MATRICULA
        // 2 - Entregar coche: pido la matricula y lo saco del garaje
        // 3 - Listar coches: se muestra toda la info - MAT - MAR - MOD - CV
        // 4 - Ver caja: se muestra la caja realizada con todos los coches
        // 5 - Salir


    }


}
