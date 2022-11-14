package com.example.menus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML private Button botonVolver;
    @FXML private Label textoRecuperar;
    @FXML private TextField textoVolver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // metodo de comunicacion
    public void recepcionarTexto(String texto){
        textoRecuperar.setText(texto);
    }
}
