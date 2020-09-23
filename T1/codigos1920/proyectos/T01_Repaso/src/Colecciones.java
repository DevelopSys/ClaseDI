import utils.Alumno;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Colecciones {

    public static void main(String[] args) {
        ArrayList<Alumno> listaAlumnos = new ArrayList();
        listaAlumnos.add(new Alumno("nombre1", "apellido"
                , "asd", 123));
        listaAlumnos.add(new Alumno("nombre2", "apellido"
                , "asd", 234));
        listaAlumnos.add(new Alumno("nombre3", "apellido"
                , "asd", 123));


        for (Alumno item : listaAlumnos) {
            if (item.getMatricula() == 234) {
                System.out.println(item.getNombre());

            }
        }

        System.out.println(listaAlumnos.size());


        Hashtable<String, Alumno> listaHash = new Hashtable();
        // añadir datos

        listaHash.put("123F", new Alumno("n1", "a1", "123F", 123));
        Alumno a = new Alumno("n2", "a", "234F", 123);
        listaHash.put(a.getDni(), a);
        Alumno a1 = new Alumno("n3", "a", "234F", 123);
        listaHash.put(a.getDni(), a1);
        Alumno a2 = new Alumno("n4", "a", "234F", 123);
        listaHash.put(a.getDni(), a2);
        Alumno a3 = new Alumno("n5", "a", "234F", 123);
        listaHash.put(a.getDni(), a3);

        // borrar datos

        listaHash.remove("123F");

        // obtener datos

        Alumno encontrado = listaHash.get("234F");

        // tamaño

        listaHash.size();

        // está?

        listaHash.containsKey("234F");

        // listado


        Enumeration<Alumno> elementos =  listaHash.elements();

        while (elementos.hasMoreElements()){
            Alumno alumno = elementos.nextElement();
            System.out.println(alumno.toString());
        }

        Enumeration<String> claves = listaHash.keys();

        while (claves.hasMoreElements()){
            String clave = claves.nextElement();
            Alumno encontradoKey = listaHash.get(clave);
        }


        Alumno agregar = new Alumno("asd","asd","asd",123);

        listaHash.put(agregar.getDni(),agregar);

        

    }
}


