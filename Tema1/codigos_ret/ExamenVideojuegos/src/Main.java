import controller.Plataforma;
import model.ClasificacionEdad;
import model.VideojuegoAccion;
import model.VideojuegoEstrategia;
import model.VideojuegoRPG;

public class Main {

    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();
        // String titulo, String autor, int anio, double precio, ClasificacionEdad calificacionEdad, boolean mundoAbierto, int horasHistoria
        plataforma.addJuego(new VideojuegoRPG("FFX","Autor1",2010,50.0, ClasificacionEdad.PEGI15, true, 100));
        plataforma.addJuego(new VideojuegoRPG("FFXV","Autor2",2015,70.0, ClasificacionEdad.PEGI18, false, 50));
        plataforma.addJuego(new VideojuegoEstrategia("JMetalGear","Autor3",2000,90.0, ClasificacionEdad.PEGI18, 4, 50));
        plataforma.addJuego(new VideojuegoEstrategia("GTAVI","Autor4",2025,120.0, ClasificacionEdad.PEGI3, 5, 100));
        plataforma.addJuego(new VideojuegoAccion("Sinobi","Autor5",2015,40.0, ClasificacionEdad.PEGI15, 4, true));
        // plataforma.listarJuegos();
        //plataforma.listarPorEdad(ClasificacionEdad.PEGI3);
        // plataforma.precioTotal();
        // plataforma.buscarJuego("FFX");
        plataforma.listarTipo();

    }
}
