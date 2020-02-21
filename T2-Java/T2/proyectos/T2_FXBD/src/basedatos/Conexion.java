package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


    java.sql.Connection conn = null;
    /*String host = "192.168.64.2:3306";
    String user = "usuarioces";
    String pass = "cesjuanpablo";
    String dtbs = "retamar";*/

    String host = "192.168.64.2:3306";
    String user = "usuarioretamar";
    String pass = "retamar";
    String dtbs = "retamar";

    public Connection realizarConexion() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String newConnectionURL = "jdbc:mariadb://" + host + "/" + dtbs
                    + "?" + "user=" + user + "&password=" + pass;
            conn = (java.sql.Connection) DriverManager.getConnection(newConnectionURL);
            return conn;
        } catch (SQLException ex) {
            System.out.println("Error la Base de Datos");
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }



}
