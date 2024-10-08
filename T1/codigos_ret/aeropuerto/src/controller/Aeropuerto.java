package controller;

import model.Avion;
import model.Tractor;
import model.Vehiculo;
import model.Vuelo;

import java.util.ArrayList;

public class Aeropuerto {

    private ArrayList<Vuelo> listaVuelos;
    private ArrayList<Vehiculo> listaVehiculos;


    public Aeropuerto() {
        this.listaVuelos = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
        agregarVehiculos();
    }

    private void agregarVehiculos() {
        listaVehiculos.add(new Tractor("Linde P40 C", "ES-LP40C", 80));
        listaVehiculos.add(new Avion("N737ER", "Boeing 737", 38, 1988));
    }

    public void listarVehiculos() {
        for (Vehiculo item : listaVehiculos) {
            item.mostrarDatos();
        }
    }

    public void listarVuelos() {
        for (Vuelo item : listaVuelos) {
            item.mostrarDatos();
        }
    }

    public void listarVuelosAvion(String matricula) {
        // foreach
        // vuelo a vuelo
        // item tu avion tiene esta matricula?
        // sacas
        for (Vehiculo item : listaVehiculos) {
            if (item instanceof Avion && ((Avion) item).getMatricula().equalsIgnoreCase(matricula)) {
                for (Vuelo vuelo : ((Avion) item).getVuelos()) {
                    vuelo.mostrarDatos();
                    break;
                }
            }
        }
    }

    public void agregarVuelo(int id, String origen, String destino, int pasajeros, int km) {
        Vuelo vuelo = new Vuelo(id, origen, destino, pasajeros, km);
        // avion
        // minimo el avion >= combustible que km
        // minimo el avion >= nPasajeros que pasajeros
        // avion no puede tener 3 vuelos o mas OK
        Avion avionDisponible = null;
        Tractor tractorDisponible = null;
        for (Vehiculo item : listaVehiculos) {
            if (item instanceof Avion
                    && ((Avion) item).getVuelos().size() < 3
                    && ((Avion) item).getCombustible() >= vuelo.getKm()
                    && ((Avion) item).getCapacidadPasajeros() >= vuelo.getPasajeros()) {
                avionDisponible = (Avion) item;
                break;
            }
        }
        for (Vehiculo item : listaVehiculos) {
            if (item instanceof Tractor
                    && ((Tractor) item).getCapacidadMaletas() >= vuelo.getPasajeros()) {
                tractorDisponible = (Tractor) item;
            }
        }
        if (avionDisponible != null && tractorDisponible != null) {
            vuelo.setAvion(avionDisponible);
            vuelo.setTractor(tractorDisponible);
            avionDisponible.agregarVuelo(vuelo);
            listaVuelos.add(vuelo);
        } else {
            System.out.println("No se puede crear el vuelo por falta de aparatos");
        }
    }

    public void cancelarVuelo(int id) {
        for (Vuelo vuelo: listaVuelos) {
            if (vuelo.getId() == id){
                listaVuelos.remove(vuelo);
                for (Vehiculo avion: listaVehiculos ) {
                    if (avion instanceof Avion){
                        for ( Vuelo vueloAvion : ((Avion) avion).getVuelos()) {
                            if (vueloAvion.getId() == id){
                                ((Avion) avion).getVuelos().remove(vueloAvion);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
