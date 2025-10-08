import controller.Plataforma;
import model.VideojuegoAccion;
import model.VideojuegoEstrategia;
import model.VideojuegoRPG;

public class Main {

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();
//(String titulo, String desarrollador, int anioLanamiento, double precio, double tamanioJuego, String clasificacionEdad, int nivelViolencia, boolean multijugador) {

        plataforma.anadirjuego(new VideojuegoAccion("Accion11", "Desarrollador", 123, 10.0, 20.0, "9", 4, false));
        plataforma.anadirjuego(new VideojuegoEstrategia("Accion11", "Desarrollador", 123, 10.0, 20.0, "9", 4, 50));
        plataforma.anadirjuego(new VideojuegoRPG("Accion11", "Desarrollador", 123, 10.0, 20.0, "9", true, 50));

        plataforma.mostrarOrdenado();
        plataforma.filtrarTipo(VideojuegoEstrategia.class);
        plataforma.mostrarClasificador("5");


    }
}
