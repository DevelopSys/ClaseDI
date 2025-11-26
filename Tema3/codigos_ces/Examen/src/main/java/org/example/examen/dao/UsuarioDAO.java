package org.example.examen.dao;

import org.example.examen.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean estaUsuario(String correo, String pass){
        connection = DBConnection.getConnection();
        String query = String.format("SELECT * FROM %s WHERE %s=? AND %s=?","usuarios","correo","pass");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,correo);
            preparedStatement.setString(2,pass);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("query erronea");
        }
        return false;
    }
}
