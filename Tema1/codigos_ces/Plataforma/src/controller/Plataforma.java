package controller;

import model.Descargable;
import model.Videojuego;
import model.VideojuegoEstrategia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Plataforma {

    private ArrayList<Videojuego> listaJuegos;
    private ArrayList<Videojuego> carritoCompra;

    public Plataforma() {
        this.listaJuegos = new ArrayList<>();
    }

    public void anadirjuego(Videojuego videojuego) {
        listaJuegos.add(videojuego);
    }

    public void eliminarJuego(int id) {
        if (estaJuego(id) == null) {
            System.out.println("No esta el juego que quieres borra");
        } else {
            listaJuegos.remove(estaJuego(id));
        }
    }

    public void mostrarClasificador(String edad) {
        for (Videojuego item : listaJuegos) {
            if (item.getClasificacionEdad().equals(edad)) {
                System.out.println(item);
            }
        }
    }

    public void mostrarPrecioJuegos() {

        double totalJuegos = 0.0;
        for (Videojuego item : listaJuegos) {
            System.out.println("El juego con nombre " + item.getTitulo());
            System.out.println("Tiene un precio de " + item.calcularPrecioFinal());
            totalJuegos += item.calcularPrecioFinal();
        }

        System.out.println("El total de los juegos es " + totalJuegos);
    }

    public void obtenerVideojuegoId(int id){
        if (estaJuego(id)!=null){
            System.out.println(estaJuego(id));
        } else {
            System.out.println("No se encuentra");
        }
    }

    public void tiempoDescarga(int id){
        if (estaJuego(id)!=null){
            ((Descargable)(estaJuego(id))).calcularTiempoDescarga(1231);
        }
    }

    public void mostrarOrdenado() {
        listaJuegos.sort(new Comparator<Videojuego>() {
            @Override
            public int compare(Videojuego o1, Videojuego o2) {
                if (o1.calcularPrecioFinal() > o2.calcularPrecioFinal()) {
                    return -1;
                }else if (o1.calcularPrecioFinal() < o2.calcularPrecioFinal()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void filtrarTipo(Class tipo){
        for ( Videojuego item: listaJuegos) {
            if(item.getClass().equals(tipo)){
                System.out.println(item);
            }
        }
    }

    private Videojuego estaJuego(int id) {
        for (Videojuego item : listaJuegos) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Videojuego> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(ArrayList<Videojuego> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }
}
