package org.example.formularioapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {

    @FXML
    private Label etiquetaTitulo;
    private String textoComunicado;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        etiquetaTitulo.setText("Ventana arrancada correctamente");
    }

    public void setTexto(String texto){
        textoComunicado = texto;
        etiquetaTitulo.setText(textoComunicado);
    }
}
