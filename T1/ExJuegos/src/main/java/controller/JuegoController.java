package controller;

import model.Clasificacion;
import model.Juego;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class JuegoController {

    private FileController fileController;
    private List<Juego> listaJuegos;
    private List<Juego> listaCarrito;
    private int ids = 0;

    public JuegoController() {

        listaJuegos = new ArrayList<>();
        listaCarrito = new ArrayList<>();
        fileController = new FileController();
    }

    public void addJuego(Juego j) {
        if (listaJuegos.stream().filter(item -> item.getId() == j.getId()).findAny().isPresent()) {
            System.out.println("Juego con ese id ya presente");
        } else {
            ids++;
            j.setId(ids);
            listaJuegos.add(j);
        }
    }

    public void addCarrito(String titulo) {

        Optional<Juego> juego = listaJuegos.stream()
                .filter(item -> item.getTitulo().equalsIgnoreCase(titulo)).findAny();
        if (juego.isPresent()) {
            listaCarrito.add(juego.get());
        } else {
            System.out.println("no se ha encontrado juego con ese titulo");
        }

    }

    public void eliminarCarrito(String titulo) {
        Optional<Juego> juego = listaJuegos.stream()
                .filter(item -> item.getTitulo().equalsIgnoreCase(titulo)).findAny();
        if (juego.isPresent()) {
            listaCarrito.remove(juego.get());
        } else {
            System.out.println("no se ha encontrado juego con ese titulo");
        }
    }

    public void ordenarJuegos() {
        listaJuegos = listaJuegos.stream()
                .sorted(Comparator.comparingDouble(Juego::getPrecio).reversed()).toList();
    }

    public void filtrarClasificacion(Clasificacion clasificacion) {
        listaJuegos.stream()
                .filter(item -> item.getClasificacion() == clasificacion).toList()
                .forEach(Juego::mostrarDatos);

        for (Juego juego : listaJuegos) {
            if (juego.getClasificacion() == clasificacion) {
                juego.mostrarDatos();
            }
        }
    }

    public void calcularPrecio() {

        double precioTotal = listaJuegos.stream().mapToDouble(Juego::getPrecio).sum();

        double sum = 0.0;
        for (Juego item: listaJuegos) {
            // sum += item.calcularPrecio();
        }

    }

    public void exportarCarrito(){
        fileController.exportCSV(listaCarrito);
    }


}
