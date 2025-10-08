package controller;

import model.ClasificacionEdad;
import model.Videojuego;
import model.VideojuegoEstrategia;

import java.util.ArrayList;
import java.util.Comparator;

public class Plataforma {
    private ArrayList<Videojuego> listaVideojuegos;
    private ArrayList<Videojuego> carrito;
    private double caja;

    public Plataforma() {
        listaVideojuegos = new ArrayList<>();
    }

    public void addJuego(Videojuego juego) {
        if (estaJuego(juego.getTitulo()) == null) {
            listaVideojuegos.add(juego);
            //caja += juego.calcularPrecioFinal();
        }
    }

    public void eliminarJuego(String titulo) {
        if (listaVideojuegos.remove(estaJuego(titulo))) {
            System.out.println("Juego borrado");
        } else {
            System.out.println("El juego no esta");
        }
    }

    public void buscarJuego(String titulo) {
        Videojuego juegoBuscado = estaJuego(titulo);
        if (juegoBuscado != null) {
            System.out.println("Los datos del juego son");
            System.out.println(juegoBuscado);
        } else {
            System.out.println("No esta el juego");
        }
    }

    public void listarPorEdad(ClasificacionEdad edad) {
        for (Videojuego item : listaVideojuegos) {
            if (item.getCalificacionEdad() == edad) {
                System.out.println(item);
            }
        }
    }

    public void precioTotal() {

        for (Videojuego item : listaVideojuegos) {
            caja += item.calcularPrecioFinal();
        }

        System.out.println("La caja total es de " + caja);
    }

    public void listarJuegos(){
        for (Videojuego item: listaVideojuegos) {
            System.out.println(item);
        }
    }

    public void listarTipo(){
        for (Videojuego item: listaVideojuegos) {
            if (item instanceof VideojuegoEstrategia){
                System.out.println(item);
            }
        }
    }

    public void ordenarPrecio() {
        listaVideojuegos.sort(new Comparator<Videojuego>() {
            @Override
            public int compare(Videojuego o1, Videojuego o2) {
                if (o1.getPrecio() > o2.getPrecio())
                    return -1;
                else if (o1.getPrecio() < o2.getPrecio())
                    return 1;
                else
                    return 0;
            }
        });
    }

    private Videojuego estaJuego(String titulo) {
        for (Videojuego item : listaVideojuegos) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }
        return null;
    }

}
