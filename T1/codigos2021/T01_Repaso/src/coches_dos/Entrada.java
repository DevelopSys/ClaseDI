package coches_dos;

public class Entrada {

    public static void main(String[] args) {
        Garaje garaje =new Garaje();
        Coche focus = new Coche("Ford","Focus",150);
        Coche ibiza = new Coche("Seat","Ibiza",200);

        garaje.aceptarCoche(focus,"aceite");
        garaje.devolverCoche();
        garaje.aceptarCoche(ibiza,"aceite");
        garaje.devolverCoche();
        garaje.aceptarCoche(focus,"aceite");
        garaje.devolverCoche();
        garaje.aceptarCoche(ibiza,"motor");
        garaje.devolverCoche();

        System.out.println(ibiza);
        System.out.println(focus);
    }
}
