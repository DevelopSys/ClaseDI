package controladora;

import basedatos.Conexion;
import basedatos.DatosBD;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Coche;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControladoraPIntro implements Initializable {

    @FXML
    TextField textMatricula, textoModelo, textoCV, textoAnio;

    @FXML
    Button bAgregar;

    ObservableList lista;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String modelo = textoModelo.getText();
                String matricula = textMatricula.getText();
                int cv = Integer.parseInt(textoCV.getText());
                int anio = Integer.parseInt(textoAnio.getText());
                Coche c = new Coche(modelo, matricula, cv, anio);
                lista.add(c);

                Thread t = new Thread() {
                    @Override
                    public void run() {
                        Connection c = null;
                        try {
                            c = Conexion.dbConnector();
                            String query = "INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s',%d,%d)";
                            c.createStatement().execute(String.format(query
                            , DatosBD.TAB_COCH
                            ,DatosBD.TAB_COCH_MOD
                            ,DatosBD.TAB_COCH_MAT
                            ,DatosBD.TAB_COCH_CV
                            ,DatosBD.TAB_COCH_ANIO
                            ,modelo, matricula,cv,anio));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                c.close();
                            } catch (SQLException e) {

                            }
                        }
                    }
                };

                t.start();

                Stage s= (Stage) bAgregar.getScene().getWindow();
                s.close();
            }
        });
    }

    public void setLista(ObservableList<Coche> lista) {
        this.lista = lista;

    }
}
