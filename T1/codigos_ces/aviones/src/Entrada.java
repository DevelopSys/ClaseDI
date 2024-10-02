import controller.Aeropuerto;
import model.Vuelo;

public class Entrada {

    public static void main(String[] args) {

        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.anadirVuelo(new Vuelo(1, "Mad","Bcn",120,1000));
        aeropuerto.anadirVuelo(new Vuelo(1, "Mad","Bcn",120,1000));
        aeropuerto.anadirVuelo(new Vuelo(1, "Mad","Bcn",120,1000));
        aeropuerto.listarVehiculos();
        aeropuerto.cancelarVuelto(1);
        aeropuerto.listarVuelosAvion("123A");


    }
}
