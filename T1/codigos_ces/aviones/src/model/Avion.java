package model;

import java.util.ArrayList;
import java.util.Objects;

public class Avion extends Vehiculo{

    private int pasajeros, litrosCombustible;
    private ArrayList<Vuelo> listaVuelos;

    public Avion() {
    }

    public Avion(String modelo, String matricula, int pasajeros, int litrosCombustible) {
        super(modelo, matricula);
        this.pasajeros = pasajeros;
        this.litrosCombustible = litrosCombustible;
        listaVuelos = new ArrayList<>();
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("pasajeros = " + pasajeros);
        System.out.println("litrosCombustible = " + litrosCombustible);
        if (!listaVuelos.isEmpty()){
            for ( Vuelo item: listaVuelos ) {
                item.mostrarDatos();
            }
        }
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getLitrosCombustible() {
        return litrosCombustible;
    }

    public void setLitrosCombustible(int litrosCombustible) {
        this.litrosCombustible = litrosCombustible;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
}
