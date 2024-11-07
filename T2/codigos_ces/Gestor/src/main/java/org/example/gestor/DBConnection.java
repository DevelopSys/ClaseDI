package org.example.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public Connection getConnection() {
        // esta creada?
        if (connection == null) {
            // la creo
            createConnection();
        }

        // retorno
        return connection;
    }

    private void createConnection() {
        String urlString = "jdbc:mysql://%s:%d/%s";
        try {
            connection = DriverManager.getConnection(String.format(urlString, "localhost", 3306, "gestor_ces")
                    , "root", "");
            System.out.println("Conexion establecida correctamente");
        } catch (SQLException e) {
            System.out.println("Error en la conexion con MySQL");
        }
    }
}
