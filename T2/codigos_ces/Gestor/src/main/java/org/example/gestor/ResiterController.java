package org.example.gestor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ResiterController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button btnResgistrar;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField editApellido;

    @FXML
    private TextField editCorreo;

    @FXML
    private TextField editNombre;

    @FXML
    private TextField editPass;

    @FXML
    private RadioButton radioFemenino;

    @FXML
    private RadioButton radioMasculino;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        btnVolver.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnVolver) {
            // 1 -> saco ventana actual
            Stage vActual = (Stage) btnVolver.getScene().getWindow();
            // 2 -> cargo fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            // 3 -> activo fxml
            try {
                Parent parent = loader.load();
                // 4 -> creo escena con el fxml activado
                Scene scene = new Scene(parent, 500, 300);
                // 5 -> pongo escena en ventana // creo ventana y pongo escena y la hago visible
                vActual.setWidth(scene.getWidth());
                vActual.setHeight(scene.getHeight());
                vActual.setScene(scene);
                vActual.setTitle("Login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
