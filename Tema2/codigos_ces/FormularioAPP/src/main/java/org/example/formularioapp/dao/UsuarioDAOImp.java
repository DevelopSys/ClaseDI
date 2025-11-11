package org.example.formularioapp.dao;

import org.example.formularioapp.database.DBConnection;
import org.example.formularioapp.database.SchemeDB;
import org.example.formularioapp.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    // PS o ST -> executeQuery
    // RESULTSET -> SELECT
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

        List<Usuario> lista = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM "+SchemeDB.TAB_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            //[                            x]
            //  [r,r,r,r,r,r,r,r,r,r,r,r,r,r]
            while (resultSet.next()){
                // añadir los usuarios a la lista
                String nombre = resultSet.getString(SchemeDB.COL_NAME);
                String mail =resultSet.getString(SchemeDB.COL_MAIL);
                String localizacion = resultSet.getString(SchemeDB.COL_LOCATE);
                String genero = resultSet.getString(SchemeDB.COL_GEN);
                int edad = resultSet.getInt(SchemeDB.COL_AG);
                Usuario usuario = new Usuario(nombre,mail,localizacion,genero,edad,true);
                lista.add(usuario);
            }


        } catch (SQLException e) {
            System.out.println("Error en la query");
        }

        return lista;
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
