package org.example.usuarios.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public Connection getConnection() throws SQLException {

        if (connection == null){
            createConnection();
        }

        return connection;
    }

    private void createConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1/usuarios_ex";
        DriverManager.getConnection(url,"root","");
    }
}
