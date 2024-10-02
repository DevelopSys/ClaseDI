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
        listaVehiculos = new ArrayList<>();
        anadirVehiculos();
        // String modelo, String matricula, int pasajeros, int litrosCombustible
        listaVuelos = new ArrayList<>();
    }

    public void anadirVuelo(Vuelo vuelo) {
        // asociar un tractor y un avion
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof Avion) {
                if (((Avion) vehiculo).getPasajeros() >= vuelo.getPasajeros()
                        && ((Avion) vehiculo).getLitrosCombustible() >= vuelo.getKm()
                        && ((Avion) vehiculo).getListaVuelos().size() < 3) {
                    vuelo.setAvion((Avion) vehiculo);
                    ((Avion) vehiculo).getListaVuelos().add(vuelo);
                }
            }
            if (vehiculo instanceof Tractor) {
                if (((Tractor) vehiculo).getCapacidadMaletas() >= vuelo.getPasajeros()) {
                    vuelo.setTractor((Tractor) vehiculo);
                }
            }
        }

    }
    public void listarVehiculos(){
        for ( Vehiculo item : listaVehiculos ) {
            item.mostrarDatos();
        }
    }
    public void listarVuelos(){
        for ( Vuelo vuelo: listaVuelos ) {
            vuelo.mostrarDatos();
        }
    }
    public void listarVuelosAvion(String matricula){
        for ( Vehiculo item : listaVehiculos ) {
            if (item instanceof Avion && item.getMatricula().equalsIgnoreCase(matricula)){
                for ( Vuelo itemVuelo : ((Avion) item).getListaVuelos() ) {
                    itemVuelo.mostrarDatos();
                }
                break;
            }

        }
    }

    public void cancelarVuelto(int id){
        for ( Vuelo vuelo: listaVuelos  ) {
            if (vuelo.getId() == id){
                listaVuelos.remove(vuelo);
                break;
            }
        }

        for (Vehiculo vehiculo : listaVehiculos ) {
            if (vehiculo instanceof Avion){
                for (int i = 0; i < ((Avion) vehiculo).getListaVuelos().size(); i++) {
                    if (((Avion) vehiculo).getListaVuelos().get(i).getId() == id){
                        ((Avion) vehiculo).getListaVuelos().remove(((Avion) vehiculo).getListaVuelos().get(i));
                    }
                    break;
                }
            }
        }


    }

    private void anadirVehiculos() {
        listaVehiculos.add(new Avion("Modelo1", "Marca1", 200, 10000));
        listaVehiculos.add(new Avion("Modelo2", "Marca2", 150, 20000));
        listaVehiculos.add(new Avion("Modelo3", "Marca3", 100, 5000));
        listaVehiculos.add(new Tractor("Modelo1", "Marca1", 70));
        listaVehiculos.add(new Tractor("Modelo1", "Marca2", 120));
        listaVehiculos.add(new Tractor("Modelo1", "Marca3", 190));
    }
}
