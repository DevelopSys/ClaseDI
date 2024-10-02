package model;

public class Vuelo {

    private int id;
    private String origen, destino;
    private int pasajeros;
    private int km;
    private Avion avion;
    private Tractor tractor;

    public Vuelo() {
    }

    public Vuelo(int id, String origen, String destino, int pasajeros, int km) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.pasajeros = pasajeros;
        this.km = km;
    }


    public void mostrarDatos(){
        System.out.println("id = " + id);
        System.out.println("origen = " + origen);
        System.out.println("destino = " + destino);
        System.out.println("avion = " + avion.getModelo());
        System.out.println("tractor = " + tractor.getModelo());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Tractor getTractor() {
        return tractor;
    }

    public void setTractor(Tractor tractor) {
        this.tractor = tractor;
    }
}
