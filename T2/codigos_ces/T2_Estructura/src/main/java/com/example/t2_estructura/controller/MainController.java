package com.example.t2_estructura.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonPulsar, botonObtener;

    @FXML
    private TextField textoNombre;

    @FXML
    private Label textoSalida;

    private ArrayList<String> usuarios;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // se ejecuta - loader.load()
        instancias();
        botonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (textoNombre.getText().length() > 0) {
                    /*textoSalida.setText(String.format("Perfecto %s has completado tu primera app de JavaFX",
                            textoNombre.getText()));*/
                    usuarios.add(textoNombre.getText());
                    textoNombre.clear();
                } else {
                    textoSalida.setText("Por favor faltan datos");
                }
                //System.out.println("Elemento pulsado correctamente");
            }
        });
        botonObtener.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (usuarios.size() == 0) {
                    textoSalida.setText("No hay usuarios");
                } else {
                    int radom = (int) (Math.random() * usuarios.size());
                    textoSalida.setText("El usuario seleccionado es: " + usuarios.get(radom));
                }
            }
        });
    }

    private void instancias() {
        usuarios = new ArrayList<>();
    }
}
