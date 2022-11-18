package com.example.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private Button botonVolver;
    @FXML
    private Label textoRecuperar;
    @FXML
    private TextField textoVolver;

    private HelloController helloController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                helloController.setTexto("Texto que quiero pasar");
                // sacar la ventana donde estoy
                Stage vetanaActual = (Stage) botonVolver.getScene().getWindow();
                vetanaActual.close();
            }
        });
    }

    // metodos de comunicacion
    public void setController(HelloController controller) {
        this.helloController = controller;
    }

    public void recepcionarTexto(String texto) {
        textoRecuperar.setText(texto);
    }
}
