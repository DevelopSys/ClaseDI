package model;

import java.util.ArrayList;

public class Avion extends Vehiculo{

    private int capacidadPasajeros, combustible;
    // private int nVuelos;
    private ArrayList<Vuelo> vuelos;

    public Avion() {}

    public Avion(String matricula, String marca, int capacidadPasajeros, int combustible) {
        super(matricula, marca);
        this.capacidadPasajeros = capacidadPasajeros;
        this.combustible = combustible;
        vuelos = new ArrayList<>();
    }
    
    public void agregarVuelo(Vuelo vuelo){
        vuelos.add(vuelo);
    } 
    
    public void eliminarVuelo(Vuelo v){
        vuelos.remove(v);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("capacidadPasajeros = " + capacidadPasajeros);
        System.out.println("combustible = " + combustible);
        System.out.println("Vuelos programados");
        for ( Vuelo v : vuelos ) {
            System.out.println("\tVuelo con ID = " + v.getId());
            // v.mostrarDatos();
        }
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }
}
