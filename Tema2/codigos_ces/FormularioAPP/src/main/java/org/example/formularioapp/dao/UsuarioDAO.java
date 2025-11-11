package org.example.formularioapp.dao;

import org.example.formularioapp.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    void insertarUsuario(Usuario usuario)  throws SQLException;
    List<Usuario> obtenerUsuarios();
    List<Usuario> obtenerUsuarios(String correo);
    int borrarUsuarios(String nombre);
    // int borrarUsuarios(String correo, String nombre);

    // la firma de todos los metodos que necesito contra DB

}
