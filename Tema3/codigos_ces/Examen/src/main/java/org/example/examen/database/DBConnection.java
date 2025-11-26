package org.example.examen.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null) {
            // crearla
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen", "root", "root");
        } catch (SQLException e) {
            System.out.println("Error en conexion");
        }
    }
}
