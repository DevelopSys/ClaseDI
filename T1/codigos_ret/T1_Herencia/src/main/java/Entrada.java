import model.Prioridad;
import model.Tarea;
import model.TareaOcio;
import model.TareaTrabajo;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        //TareaOcio tareaOcio1 = new TareaOcio();
        TareaOcio tareaOcio2 = new TareaOcio(1,"Tarea Ocio", "Descripcion","Enero2024",
                Prioridad.alta, "Pozuelo", 1000);
        TareaOcio tareaOcio1 = new TareaOcio(2,"Tarea Ocio", "Descripcion","Enero2024",
                Prioridad.alta, "Pozuelo", 40);
        TareaTrabajo tareaTrabajo1 = new TareaTrabajo(3, "Tarea Trabajo","Ejemplo de tarea trabajo",
                "Febrero 2024",Prioridad.alta,"Desarrollo Web");
        TareaTrabajo tareaTrabajo2 = new TareaTrabajo(3, "Tarea Trabajo","Ejemplo de tarea trabajo",
                "Febrero 2024",Prioridad.alta,"Movil");

        tareaOcio1.agregarSubtarea(tareaOcio2);
        tareaOcio1.agregarSubtarea(tareaTrabajo1);
        tareaOcio1.agregarSubtarea(tareaTrabajo2);

        /*ArrayList<Tarea> tareasGenerales = new ArrayList<>();
        tareasGenerales.add(tareaOcio2);
        tareasGenerales.add(tareaOcio1);
        tareasGenerales.add(tareaTrabajo1);
        tareasGenerales.add(tareaTrabajo2);

        for ( Tarea item : tareasGenerales ) {
            item.completar();
        }*/

    }
}
