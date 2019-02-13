package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


    public static Connection dbConnector() throws SQLException {
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String host = "192.168.64.2:3306";
        String dbname = "bdexamen";
        String url = "jdbc:mariadb://" + host + "/" + dbname;
        String username = "adminii";
        String password = "retamar";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}

