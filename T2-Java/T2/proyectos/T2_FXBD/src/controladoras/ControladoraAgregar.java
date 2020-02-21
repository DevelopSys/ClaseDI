package controladoras;

import basedatos.Conexion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import utils.SchemaDB;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControladoraAgregar implements Initializable {

    @FXML
    Button boton_agregar;

    @FXML
    TextField nombre, apellido, telefono;

    private Conexion conexion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        conexion = new Conexion();
        boton_agregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {

                    Connection connection = conexion.realizarConexion();
                    //conexion.realizarConexion();
                    PreparedStatement preparedStatement =connection.prepareStatement("INSERT INTO alumno " +
                            "(nombre,apellido,telefono) VALUES (?,?,?)");
                    preparedStatement.setString(1,nombre.getText());
                    preparedStatement.setString(2,apellido.getText());
                    preparedStatement.setInt(3,Integer.valueOf(telefono.getText()));
                    preparedStatement.executeUpdate();
                    connection.close();


                    // o ejecuto la query directamente
                    String query = "INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s',%d)";
                    Statement st = connection.createStatement();
                    st.executeQuery(String.format(query,SchemaDB.nombre_table,
                            SchemaDB.columna_nombre,
                            SchemaDB.columna_apellido,
                            SchemaDB.columna_telefono,
                            nombre.getText(),
                            apellido.getText(),
                            Integer.valueOf(telefono.getText())));
                    st.close();
                    connection.close();


                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //System.out.println("agregado");
                //conexion.getConn();
            }
        });
    }

}
