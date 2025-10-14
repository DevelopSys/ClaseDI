package org.example.appinicial;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button buttonPulsar;

    @FXML
    private Label labelSaludo;

    @FXML
    private TextField textfieldNombre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Ejecutado directamente en la asociacion de la stage

        acciones();
    }

    private void acciones() {
        buttonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // el metodo a ejecutar cuando el boton sea pulsado
                System.out.println("Boton pulsado correctamente");
            }
        });
    }
}
