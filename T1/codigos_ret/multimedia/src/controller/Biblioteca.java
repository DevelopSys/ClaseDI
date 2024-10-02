package controller;

import model.*;

import javax.swing.text.View;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Multimedia> listaMultimieda;

    public Biblioteca() {
        listaMultimieda = new ArrayList<>();
    }

    // agregar elemento -> no pueden existir dos elementos con el mismo ID
    public void agregarElemento(Multimedia multimedia) {
        if (buscarElemento(multimedia.getId()) == null) {
            // el id no esta en la lisa
            listaMultimieda.add(multimedia);
            System.out.println("Elemento agregaro correctamente");
            //multimedia.mostrarDatos();
        }
    }

    // 1-> todos 2->Libros 3->Audio 4->Video
    public void listarElementos(int tipo) {
        for (Multimedia item : listaMultimieda) {
            if (item instanceof Libro && tipo==2)
                item.mostrarDatos();
            else if (item instanceof Audio && tipo==3)
                item.mostrarDatos();
            else if (item instanceof Video && tipo==4)
                item.mostrarDatos();
            else
                item.mostrarDatos();
        }
        /*switch (tipo) {
            case 1:
                for (Multimedia item : listaMultimieda) {
                    item.mostrarDatos();
                }
                break;
            case 2:
                for (Multimedia item : listaMultimieda) {
                    if (item instanceof Libro)
                        item.mostrarDatos();
                }
                break;
            case 3:
                for (Multimedia item : listaMultimieda) {
                    if (item instanceof Audio)
                        item.mostrarDatos();
                }
                break;
            case 4:
                for (Multimedia item : listaMultimieda) {
                    if (item instanceof Video)
                        item.mostrarDatos();
                }
                break;
        }*/
    }

    public void eliminarElemento(int id) {
        Multimedia multimedia = buscarElemento(id);
        if (multimedia != null) {
            listaMultimieda.remove(multimedia);
        }
    }

    public void buscarElementoId(int id) {
        Multimedia multimedia = buscarElemento(id);
        if (multimedia != null) {
            multimedia.mostrarDatos();
        }
    }

    private Multimedia buscarElemento(int id) {
        for (Multimedia item : listaMultimieda) {
            if (item.getId() == id) {
                return item;
            }
        }
        System.out.println("No esta el elemento con este ID");
        return null;
    }

    // quiero ver todas las peliculas en las que sale un actor
    public void listarActor(String actor){
        for ( Multimedia item: listaMultimieda ) {
            if (item instanceof Video){
                for ( Persona actorPelicula : ((Video) item).getActores() ) {
                    if (actorPelicula.getNombre().equalsIgnoreCase(actor)){
                        item.mostrarDatos();
                    }
                }
            }
        }
    }


}
