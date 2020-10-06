package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML Button botonCambio;

    Scene segundaScena;
    Stage stagePrincipal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        acciones();

    }

    private void acciones() {

        botonCambio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Boton pulsado");

                // Crear la scena

                // parent --> fxml
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("segunda.fxml"));
                    segundaScena = new Scene(root,600,400);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                stagePrincipal = (Stage) botonCambio.getScene().getWindow();



                // Al pulsar boton --> en la ventana pongo la nueva scene
                stagePrincipal.setScene(segundaScena);
            }
        });




    }


}
