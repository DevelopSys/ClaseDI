package org.example.usuarios.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection sqlConnection;

    public Connection getConnecion(){

        if (sqlConnection ==null){
            createConnection();
        }

        return sqlConnection;
    }

    private void createConnection() {
        String url = "jdbc:mysql://127.0.0.1/usuarios_ex";
        try {
            DriverManager.getConnection(url,"root","");
        } catch (SQLException e) {
            System.out.println("error en la conexion");
        }
    }
}
