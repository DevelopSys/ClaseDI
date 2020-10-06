package listas;

import herencia.Alumno;
import herencia.Persona;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class Entrada {

    public static void main(String[] args) {
        // ArrayList<String> lista = new ArrayList();
        // System.out.println(lista.size());

        // add(elemento)--> añade a la lista al final
        // add(index, elemento) --> añade en un sitio concreto
        // remove(index) --> borra el elemento de la posicion
        // remove(value) --> borra la primera instancia del valor
        // get(index) --> obtengo el valor del index
        // clear() --> borra
        // size() --> tamaño de la lista

        /*Hashtable<String,String> listaHash = new Hashtable();
        // tamaño
        System.out.println(listaHash.size());

        // añadir
        listaHash.put("hola","hi");
        listaHash.put("adios","bye");

        // obtener
        String elemento = listaHash.get("adios");
        System.out.println(elemento);

        // existe
        boolean existe = listaHash.containsKey("holas");
        System.out.println(existe);

        // borrar
        listaHash.remove("hola");
        System.out.println(listaHash.size());*/

        Hashtable<String, Persona> agenda = new Hashtable();

        agenda.put("1234A", new Alumno("borja","martin","1234A",10));
        agenda.put("2345B", new Alumno("pepe","herrera","2345B",4));
        agenda.put("3456C", new Alumno("jose","gonzalez","3456C",6));
        agenda.put("4567D", new Alumno("luis","diego","4567D",10));

        System.out.println(agenda.size());

        Persona encontrado = agenda.get("2345B");
        //System.out.println(encontrado.getNombre());

        // por claves
        Enumeration<String> claves = agenda.keys();
        // 1,2,3,4,5,6,7,8,9,0
        /*while (claves.hasMoreElements()){
            String key = claves.nextElement();
            Persona encontradoBucle = agenda.get(key);
            System.out.println(encontradoBucle.getNombre());
        }*/

        // por colección

        Collection<Persona> personas = agenda.values();
        for (Persona item:personas) {
            if(((Alumno)item).getMediaAcademica()>7){
                System.out.println(item.getNombre());
            }

        }








    }
}
