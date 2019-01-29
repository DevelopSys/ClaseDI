package controladora;

import com.jfoenix.controls.JFXButton;
import com.sun.deploy.util.FXLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ventanas.VentanaNueva;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlVentanaGeneral implements Initializable, EventHandler<ActionEvent> {



    @FXML
    JFXButton botonNuevaVentana, botonNuevaScena;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

       acciones();

    }

    private void acciones() {
        botonNuevaVentana.setOnAction(this);
        botonNuevaScena.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == botonNuevaVentana){
            VentanaNueva v = new VentanaNueva();
            Stage stage = new Stage();
            try {
                v.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (event.getSource() == botonNuevaScena){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../vista/scenenueva.fxml"));
                Scene scene = new Scene(root,600,600);
                Stage stage = (Stage) botonNuevaScena.getScene().getWindow();
                stage.setScene(scene);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
