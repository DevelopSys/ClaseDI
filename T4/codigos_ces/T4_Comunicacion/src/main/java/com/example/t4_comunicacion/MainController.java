package com.example.t4_comunicacion;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainController implements Initializable {
    @FXML
    private Button botonComunicar;

    @FXML
    private TextField textoNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonComunicar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // cambiar la escena. Pasos

                // 1 - cargar el fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("second-view.fxml"));
                // 2 - crear la escena y asociarla al root
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,botonComunicar.getScene().getWidth(),botonComunicar.getScene().getHeight());
                    // 3 - poner la escena en la ventana
                    // un elemento grafico
                    Stage ventana = (Stage) botonComunicar.getScene().getWindow();
                    ventana.setScene(scene);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }



            }
        });
    }
}