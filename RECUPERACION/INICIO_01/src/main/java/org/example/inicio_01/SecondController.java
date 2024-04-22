package org.example.inicio_01;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    Label inputNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void comunicarDato(String nombre){
        inputNombre.setText(nombre);
    }
}
