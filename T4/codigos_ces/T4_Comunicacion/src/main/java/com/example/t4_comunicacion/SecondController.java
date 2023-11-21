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

public class SecondController implements Initializable {

    @FXML
    private Label nombre;

    @FXML
    private Button botonVolver;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // 1 - cargar el fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
                // 2 - crear la escena y asociarla al root
                try {
                    Parent root = loader.load();
                    MainController mainController = loader.getController();
                    mainController.setRespuesta();
                    Scene scene = new Scene(root,botonVolver.getScene().getWidth()
                            ,botonVolver.getScene().getHeight());
                    // 3 - poner la escena en la ventana
                    // un elemento grafico
                    Stage ventana = (Stage) botonVolver.getScene().getWindow();
                    ventana.setScene(scene);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    // TODO comunicacion unidireccional
    // TODO Paso 1: Creo un metodo con lo que quiero obtener
    public void comunicarNombre(String nom){
        nombre.setText(nom);
    }

}
