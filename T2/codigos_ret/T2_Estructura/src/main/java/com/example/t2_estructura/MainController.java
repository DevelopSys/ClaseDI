package com.example.t2_estructura;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Button botonPulsar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ejecuta directamente cuando se lee el atributo fx:controller
        botonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                welcomeText.setText("Ejemplo de cambio");
            }
        });
    }
}