package agenda;

import java.util.ArrayList;

public class Entrada {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.agregarUsuario(new Persona("borja","hjgvfc","mnjhgfc",123));
        agenda.agregarUsuario(new Persona("luis","asd","asd",123));
        agenda.agregarUsuario(new Persona("pedro","asd","asd",123));
        agenda.agregarUsuario(new Persona("jose","asd","asd",123));

        agenda.listarTodos();

        System.out.println(agenda.getListaPersonas().size());
        agenda.getPersona("borja");
        agenda.borrarPersona("jose");

        agenda.listarTodos();
        System.out.println(agenda.getListaPersonas().size());



    }
}
