package controladoras;

import basedatos.Conexion;
import basedatos.DatosBD;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import utils.Usuario;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControlBD implements Initializable {

    @FXML
    Button btnInsertar, btnBorrar, btnActualizar, btnConsultar;

    Connection connection = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {

        btnActualizar.setOnAction(new ManejoAcciones());
        btnBorrar.setOnAction(new ManejoAcciones());
        btnConsultar.setOnAction(new ManejoAcciones());
        btnInsertar.setOnAction(new ManejoAcciones());

    }

    private void agregarUsuario(Usuario usuario){
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    connection = Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    //st.execute("INSERT INTO inicio (nombre,apellido,correo) VALUES ('','','')");
                    String query = "INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s','%s')";
                    if (st.execute(String.format(query
                            , DatosBD.TAB_INICIO
                            , DatosBD.TAB_INICIO_COL_NOM
                            , DatosBD.TAB_INICIO_COL_AP
                            , DatosBD.TAB_INICIO_COL_CORR
                            , usuario.getNombre()
                            , usuario.getApellido()
                            , usuario.getCorreo()))){
                        System.out.println("inserción correcta");
                    }else {
                        System.out.println("la insercion no es correcta");
                    }
                    connection.commit();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }

    private void borrarUsuario(String nombre){
        System.out.println("ejecución");
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    connection = Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    String query = "DELETE FROM %s WHERE %s='%s'";
                    if (st.execute(String.format(query,
                            DatosBD.TAB_INICIO,
                            DatosBD.TAB_INICIO_COL_NOM,
                            nombre)));
                    connection.commit();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == btnInsertar) {
                agregarUsuario(new Usuario("asd","asd","asd"));
            } else if (event.getSource() == btnBorrar) {
                borrarUsuario("asd");
            } else if (event.getSource() == btnInsertar) {

            } else if (event.getSource() == btnInsertar) {

            }
        }
    }
}
