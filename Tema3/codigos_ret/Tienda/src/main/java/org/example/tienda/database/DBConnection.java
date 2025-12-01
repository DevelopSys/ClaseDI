package org.example.tienda.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null){
            // la inicializo
            createConnection();
        }
        return connection;
    }

    private static void createConnection(){
        // url
        String url = "jdbc:mysql://localhost:3306/tienda_ret";
        // user
        String user ="root";
        // pass
        String pass = "root";
        try {
            connection = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la BD");
        }
    }

}
