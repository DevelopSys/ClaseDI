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

public class ControladoraBorrar implements Initializable {

    @FXML
    Button boton_borrar;

    @FXML
    TextField nombre, apellido, telefono;

    private Connection connection;
    private Conexion conexion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        conexion = new Conexion();
        boton_borrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {

                    Connection connection = conexion.realizarConexion();
                    //conexion.realizarConexion();
                    PreparedStatement preparedStatement =connection.prepareStatement("DELETE FROM alumno " +
                            "WHERE nombre=?)");
                    preparedStatement.setString(1,nombre.getText());
                    preparedStatement.executeUpdate();
                    connection.close();

                    // o ejecuto la query directamente
                    String query = "DELETE FROM %s WHERE %s=%s)";
                    Statement st = connection.createStatement();
                    st.executeQuery(String.format(query,SchemaDB.nombre_table,
                            SchemaDB.columna_nombre,
                            nombre.getText()));
                    st.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
