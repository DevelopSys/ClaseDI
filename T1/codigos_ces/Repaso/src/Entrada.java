import model.Tarea;
import utils.Prioridad;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        ArrayList<Tarea> lista = new ArrayList<>();
        Tarea tarea = new Tarea("Titulo tarea 1", "descripcion tarea 1", 1);
        tarea.setId(1);
        lista.add(tarea);

        tarea = new Tarea("Titulo tarea 2", "descripcion tarea 2", 3);
        tarea.setId(2);
        lista.add(tarea);

        tarea = new Tarea("Titulo tarea 3", "descripcion tarea 2", 2);
        tarea.setId(3);
        lista.add(tarea);

        //Tarea tareaObtenida = lista.get(1);
        //System.out.println(tareaObtenida.getTitulo());
        //System.out.println(tareaObtenida.getPrioridad().getColor());

        /*for (Tarea item : lista){
            if (item.getPrioridad().getValor() == 1){
                System.out.println(item.getTitulo());
                // solo quero sacar la primera -> break
            }
        }*/


        // borrar todas las tareas que tienen prioridad baja

        /*for ( Tarea item : lista){
            if (item.getPrioridad().getValor() == 1){
                lista.remove(item);
            }
        }*/

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPrioridad().getValor() == 1) {
                lista.remove(i);
            }
        }

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPrioridad().getValor() == 1) {
                lista.get(i).setPrioridad(Prioridad.baja);
            }
        }


    }
}
