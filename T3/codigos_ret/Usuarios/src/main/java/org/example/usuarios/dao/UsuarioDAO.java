package org.example.usuarios.dao;

import org.example.usuarios.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    // hacer login
    public int getUsuarioLogin(String correo, String pass) throws SQLException {

        connection = new DBConnection().getConnecion();
        String query = String.format("SELECT %s FROM %s WHERE %s=? AND %s=?","id","usuarios","mail","pass");
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,correo);
        preparedStatement.setString(2,pass);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            return resultSet.getInt("id");
        }

        return -1;
    }
    // registrar usuario
    public boolean registrar(String correo, String pass) throws SQLException {
        connection = new DBConnection().getConnecion();
        String query = String.format("INSERT INTO %s (%s,%s) VALUES (?,?)","usuarios","mail","pass");
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,correo);
        preparedStatement.setString(2,pass);
        return preparedStatement.execute();
    }
    // sacar numero de productos
    public int getProductos(int idUser) throws SQLException {
        connection = new DBConnection().getConnecion();
        String query = String.format("SELECT COUNT(*) FROM %s WHERE %s=?","productos","id_usuario");
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,idUser);
        return preparedStatement.executeUpdate();
    }
    // insertar producto por id de usuario
    public boolean comprarProducto(int idUser, int idProducto) throws SQLException {
        connection = new DBConnection().getConnecion();
        String query = String.format("INSERT INTO %s (%s,%s) VALUES (?,?)","productos","id_user","id_producto");
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,idUser);
        preparedStatement.setInt(2,idProducto);
        return preparedStatement.execute();
    }
}
