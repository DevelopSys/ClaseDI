package org.example.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;


    public Connection getConnection() {

        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private void createConnection() {

        String uriConnection = String.format("jdbc:mysql://%s:%s/%s", DBSchema.HOST, DBSchema.PORT, DBSchema.DB_NAME);
        try {
            connection = DriverManager.getConnection(uriConnection, "root", "");
            System.out.println("Conexion creada correctamente");
        } catch (SQLException e) {
            System.out.println("Fallo en la conexion");
        }
    }


}
