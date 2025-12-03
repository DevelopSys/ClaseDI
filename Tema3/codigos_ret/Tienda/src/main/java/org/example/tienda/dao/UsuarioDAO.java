package org.example.tienda.dao;

import org.example.tienda.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UsuarioDAO {
    // definir la firma de todos los metodos que quieres
    // contra base de datos y el modelo Usuario

    // TODO cuidado con la clave unique
    void addUsuario(Usuario usuario) throws SQLException;

    int borrarUsuario(String nombre);

    // TODO cuidado con la clave unique
    boolean actualizarUsuario(int id, String correo);

    ArrayList<Usuario> getUsuarios();
}
