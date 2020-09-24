package coleccionesInf;

import clases.Alumno;
import clases.Persona;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class Entrada {

    public static void main(String[] args) {

        String[] palabraPosiciones = new String[10];
        String[] palabraElementos = {"Uno", "Dos", "Tres"};
        palabraElementos[0] = "Valor";

        String[][] matriz = new String[2][3];
        String[][] matrizDatos = {{"uno", "dos"}, {"tres", "cuatro", "cinco"}};

        /*for (int i = 0; i < matrizDatos.length; i++) {
            // recorro las filas
            for (int j = 0; j < matrizDatos[i].length; j++) {
                System.out.println(matrizDatos[i][j]);
            }
        }

        for (String[] item:matrizDatos) {
            // recorro las filas
            for (String itemFinal :item) {
                System.out.println(itemFinal);
            }
        }*/

        /*for (int i = 0; i < palabraElementos.length ; i++) {
            System.out.println(palabraElementos[i]);
        }

        for (String item: palabraElementos) {
            System.out.println(item);
        }*/

        /*ArrayList<String> listaPalabras = new ArrayList();
        listaPalabras.add(1,"algoNuevo");
        listaPalabras.add("algo");
        listaPalabras.get(0);
        listaPalabras.remove(1);
        listaPalabras.clear();
        listaPalabras.size();*/

        /*for (int i = 0; i < listaPalabras.size(); i++) {
            System.out.println(listaPalabras.get(i));
        }

        for (String item:listaPalabras) {
            System.out.println(item);
        }*/

        // {nombre="Borja",apellido="Martin",edad=28}

        Hashtable<String, Persona> listaPersonas = new Hashtable();

        Alumno a1 = new Alumno("sdf", "Martin", "1234", 4);
        Alumno a2 = new Alumno("tewrt", "Martin", "2345", 10);
        Alumno a3 = new Alumno("ytut", "Martin", "3456", 6);
        Alumno a4 = new Alumno("yuiyu", "Martin", "4567", 8);
        Alumno a5 = new Alumno("voyaserborrado", "Martin", "5678", 10);
        listaPersonas.put(a1.getDni(), a1);
        listaPersonas.put(a2.getDni(), a2);
        listaPersonas.put(a3.getDni(), a3);
        listaPersonas.put(a4.getDni(), a4);
        listaPersonas.put(a5.getDni(), a5);
        //listaPersonas.clear();
        //listaPersonas.size();
        //listaPersonas.remove(a.getDni());
        //listaPersonas.containsKey("1234567A");
        //listaPersonas.keys(); // todas las claves --> para recorrer
        //listaPersonas.values(); // todos los elementos --> para recorrer
        // KEY -- VALUE
        // DNI -- Persona
        System.out.println(listaPersonas.size());
        Persona pBorrada = listaPersonas.remove("5678");
        if (pBorrada != null) {
            System.out.println("la persona borrada se llama " + pBorrada.getNombre());
        } else {
            System.out.println("No se ha encontrado la persona");
        }
        System.out.println(listaPersonas.size());

        Persona pEncontrada = listaPersonas.get("1234");
        if (pEncontrada != null) {
            System.out.println("la persona borrada se llama " + pEncontrada.getNombre());
        } else {
            System.out.println("No se ha encontrado la persona");
        }

        Enumeration<String> listaClaves = listaPersonas.keys();
        //XXXXXXXX --> k1,k2,k,k,k,k,k,k,k,k

        while (listaClaves.hasMoreElements()) {
            String key = listaClaves.nextElement();
            Alumno persona = (Alumno) listaPersonas.get(key);
            if (persona.getMedia()==10){
                System.out.println(persona.getNombre());
            }
        }

        Collection<Persona> elementos = listaPersonas.values();
        for (Persona persona:elementos) {
            System.out.println(persona.getNombre());
        }


    }
}
