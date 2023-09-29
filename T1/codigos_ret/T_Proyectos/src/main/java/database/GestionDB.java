package database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class GestionDB {

    private Connection connection;

    public GestionDB() {
        createConnection();
    }

    private void createConnection() {

        try {
            Class.forName("mysql.cj.driver");
            String url = "jdbc:mysql://localhost:3306/ciclo";
            connection = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
