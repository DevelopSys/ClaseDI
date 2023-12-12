package com.example.t4_comunicaciones;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private MenuItem menuPaso1;

    @FXML
    private MenuItem menuPaso2;

    @FXML
    private Label textoComunicado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setNombre(String nombre){
        textoComunicado.setText("El dato comunicado es: "+nombre);
    }
}
