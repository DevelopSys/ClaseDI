package clases;

import java.util.Enumeration;
import java.util.Hashtable;

public class Garaje {


    private Hashtable<String, Coche> listadoCoches;

    public Garaje() {

        listadoCoches = new Hashtable();
    }

    public void agregarCoche(Coche coche) {
        listadoCoches.put(coche.getMatricula(), coche);
    }

    public void eliminarCoche(String matricula) {
        listadoCoches.remove(matricula);
    }

    public void listarAparcados(boolean aparcado) {
        Enumeration<Coche> elementos = listadoCoches.elements();
        while (elementos.hasMoreElements()){
            Coche item = elementos.nextElement();
            if (aparcado){
                if (item.isAparcado()){
                    System.out.println(item);
                }
            }
            else {
                if (!item.isAparcado()){
                    System.out.println(item);
                }
            }
        }
    }

    public boolean estaCoche(String matricula) {
        return listadoCoches.containsKey(matricula);
    }

    public void aparcarCoche(String matricula) {
        listadoCoches.get(matricula).setAparcado(true);
    }

    public void sacarCoche(String matricula) {
        listadoCoches.get(matricula).setAparcado(false);
    }

    public boolean estaAparcado(String matricula) {
        return listadoCoches.get(matricula).isAparcado();
    }


    public void listarCoches() {
        Enumeration<Coche> elementos = listadoCoches.elements();
        while (elementos.hasMoreElements()) {
            Coche c = elementos.nextElement();
            System.out.println(c);
        }
    }

    public Hashtable<String, Coche> getListadoCoches() {
        return listadoCoches;
    }
}











