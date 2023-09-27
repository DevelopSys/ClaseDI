package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionDB {

    private Connection connection;

    public GestionDB(){
        createConnecion();
    }

    public void createConnecion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url= "jdbc:mysql://"+"127.0.0.1:3306"+"/"+"Planificador";
            connection = DriverManager.getConnection(url,"root","");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
