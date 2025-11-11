package org.example.formularioapp.dao;

import org.example.formularioapp.database.DBConnection;
import org.example.formularioapp.database.SchemeDB;
import org.example.formularioapp.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UsuarioDAOImp implements UsuarioDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    // INSERT
    // UPDATE
    // DELETE
    // SELECT
    // STATEMENT o PREPARESTATEMENT
    // execute -> bool -> INSERT
    // executeUpdate -> int -> UPDATE DELETE

    public UsuarioDAOImp() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void insertarUsuario(Usuario usuario) throws SQLException{

        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES (?,?,?,?,?)",
                SchemeDB.TAB_NAME,
                SchemeDB.COL_NAME, SchemeDB.COL_MAIL, SchemeDB.COL_LOCATE, SchemeDB.COL_GEN, SchemeDB.COL_AG);

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getCorreo());
        preparedStatement.setString(3, usuario.getLocalizacion());
        preparedStatement.setString(4, usuario.getGenero());
        preparedStatement.setInt(5, usuario.getEdad());
        preparedStatement.execute();


    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return List.of();
    }

    @Override
    public List<Usuario> obtenerUsuarios(String correo) {
        return List.of();
    }

    @Override
    public int borrarUsuarios(String nombre) {
        return 0;
    }
}
