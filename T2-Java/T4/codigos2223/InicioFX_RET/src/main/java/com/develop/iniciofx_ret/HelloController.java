package com.develop.iniciofx_ret;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Button botonInicial, botonInicialDos;

    public void metodoInitGUI(){
        System.out.println("Controlador iniciado");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       acciones();
    }

    private void acciones() {
        botonInicial.setOnAction(new ManejoPulsaciones());
        botonInicialDos.setOnAction(new ManejoPulsaciones());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonInicial){
                welcomeText.setText("Boton uno pulsado");
            } else if (actionEvent.getSource() == botonInicialDos) {
                welcomeText.setText("Boton dos pulsado");
            }
        }
    }
}