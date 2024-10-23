package org.example.gestor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button btnVolver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        btnVolver.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // Capturar la ventana donde estoy
        Scene sceneActual = btnVolver.getScene();
        Stage ventanaActual = (Stage) sceneActual.getWindow();
        // Poner una escena -> welcome-view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome-view.fxml"));

        try {
            Parent root = loader.load();
            Scene scene = new Scene(root, sceneActual.getWidth(), sceneActual.getHeight());
            ventanaActual.setScene(scene);
        } catch (IOException e) {
            System.out.println("Error en la carga");
        }
    }
}
