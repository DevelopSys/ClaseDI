package controladora;

import basedatos.DatosBD;
import dialogos.DialogoIntro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.Coche;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControladoraPerso implements Initializable {

    @FXML
    ListView listaCoches;

    @FXML
    Button bAgregar, bMostrar;

    ObservableList<Coche> listaC;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        rellenarLista();
        bAgregar.setOnAction(new ManejoAcciones());
        bMostrar.setOnAction(new ManejoAcciones());
    }

    private void rellenarLista() {
        Thread t = new Thread() {
            @Override
            public void run() {
                Connection c = null;
                try {
                    c = basedatos.Conexion.dbConnector();
                    String query = "SELECT * FROM %s";
                    ResultSet rs = c.createStatement()
                            .executeQuery(String.format(query, DatosBD.TAB_COCH));
                    while (rs.next()) {
                        int id = rs.getInt(DatosBD.TAB_COCH_ID);
                        String modelo = rs.getString(DatosBD.TAB_COCH_MOD);
                        String matricula = rs.getString(DatosBD.TAB_COCH_MAT);
                        int cv = rs.getInt(DatosBD.TAB_COCH_CV);
                        int anio = rs.getInt(DatosBD.TAB_COCH_ANIO);
                        Coche coche = new Coche(id, modelo, matricula, cv, anio);
                        listaC.add(coche);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    private void instancias() {
        listaC = FXCollections.observableArrayList();
        listaCoches.setItems(listaC);
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == bAgregar) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/dialogointro.fxml"));
                Parent root = null;
                ControladoraPIntro controladoraPIntro=null;
                try {
                    root = loader.load();
                    controladoraPIntro = loader.getController();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                controladoraPIntro.setLista(listaC);
                Stage stage = new Stage();
                Scene scene = new Scene(root,300,200);
                stage.setScene(scene);
                stage.setTitle("Diálogo introducir");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();

            } else if (event.getSource() == bMostrar) {

            }
        }
    }
}
