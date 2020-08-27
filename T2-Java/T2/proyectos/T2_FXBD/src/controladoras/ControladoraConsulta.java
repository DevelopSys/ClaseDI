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
import java.sql.*;
import java.util.ResourceBundle;

public class ControladoraConsulta implements Initializable {

    @FXML
    Button boton_consulta;

    @FXML
    TextField nombre;

    private Connection connection;
    private Conexion conexion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        conexion = new Conexion();
        boton_consulta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {

                    Connection connection = conexion.realizarConexion();

                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * alumno " +
                            "WHERE nombre=?)");
                    preparedStatement.setString(1, nombre.getText());
                    ResultSet Prepare = preparedStatement.executeQuery();

                    connection.close();

                    // o ejecuto la query directamente
                    String query = "SELECT * FROM %s WHERE %s='%s')";
                    Statement st = connection.createStatement();
                    ResultSet resultSet = st.executeQuery(String.format(query,
                            SchemaDB.columna_nombre,
                            nombre.getText()));
                    while (resultSet.next()){
                        String nombre = resultSet.getString(SchemaDB.columna_nombre);
                        String apellidos = resultSet.getString(SchemaDB.columna_apellido);
                        int telefono = resultSet.getInt(SchemaDB.columna_telefono);
                    }

                    resultSet.close();
                    st.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
