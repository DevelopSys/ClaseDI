package org.example.usuarios.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.usuarios.database.DBConnection;
import org.example.usuarios.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ObservableList<Usuario> getAllUsers() throws SQLException {
        ObservableList<Usuario> lista = FXCollections.observableArrayList();

        String query = String.format("SELECT * FROM %s","usuarios");
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String correo = resultSet.getString("mail");
            String pass = resultSet.getString("pass");
            int id = resultSet.getInt("id");
            Usuario usuario = new Usuario(id,correo,pass);
            lista.add(usuario);
        }

        return lista;
    }
    public boolean insertUser(String mail, String pass) throws SQLException {
        String query = String.format("INSERT INTO %s (%s,%s) VALUES (?,?)","usuarios","mail","pass");
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,mail);
        preparedStatement.setString(2,pass);
        return preparedStatement.execute();
    }
    public boolean getLoginUser(String mail, String pass) throws SQLException {


        String query = String.format("SELECT id FROM %s WHERE %s=? AND %s=?","usuarios","mail","pass");
        connection = new DBConnection().getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,mail);
        preparedStatement.setString(2,pass);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
