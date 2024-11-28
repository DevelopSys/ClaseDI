package org.example.gestor.database;

import org.example.gestor.model.Usuario;

import java.util.ArrayList;

public class DataBase {

    static private ArrayList<Usuario> listaUsuarios;

    private static void createLista() {
        if (listaUsuarios == null) {
            listaUsuarios = new ArrayList<>();
        }
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        if (listaUsuarios == null) {
            createLista();
        }
        return listaUsuarios;
    }

    private static Usuario existeUsuario(String correo) {
        getListaUsuarios();
        for (Usuario item : listaUsuarios) {
            if (item.getCorreo().equalsIgnoreCase(correo)) {
                return item;
            }
        }
        return null;
    }

    public static void agregarUsuario(Usuario u) {
        getListaUsuarios();
        if (existeUsuario(u.getCorreo()) == null) {
            listaUsuarios.add(u);
        } else {
            System.out.println("El correo ya existe en la lista");
        }
    }
}
