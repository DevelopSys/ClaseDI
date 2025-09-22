import model.Persona;
import model.Tarea;

public class Main {
    public static void main(String[] args) {
        Tarea tareaPrincipal = new Tarea();
        Tarea tareaSecundaria = new Tarea(1, "Estudiar", "Esta tarea me ayudara a centrarme en el dia a dia del estucio",
                new Persona("1234A", "Borja", "Martin", 41));
        Tarea tareaSecundaria2 = new Tarea(3, "Practicar", "descipcion de la tarea",
                new Persona("2345C", "Juan", "Garcia", 26),
                5);


        // como saco el nombre del respoonsable de la tarea secundaria
        System.out.println(tareaSecundaria.getResponsable().getNombre());


        // cuantas personas hay en el equipo de trabajo de la tarea secundaria
        Persona personaVacia = new Persona();
        Persona persona = new Persona("1234A", "Borja", "Martin", 41);
        System.out.println(tareaPrincipal);
        System.out.println(tareaSecundaria);
        System.out.println(tareaPrincipal.equals(tareaSecundaria));

        System.out.println(personaVacia);
        System.out.println(persona);
        // tareaSecundaria.setTitulo("Estu");
        // System.out.println(tareaSecundaria.getTitulo(1234));

    }
}
