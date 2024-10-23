package org.example.gestor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Label welcomeText;

    @FXML
    private Button btnLogin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        acciones();
    }

    private void acciones() {
        btnLogin.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnLogin){
            // acceso a la ventana login
            Stage ventanaLogin = (Stage) btnLogin.getScene().getWindow();

            Stage ventanaMain = new Stage();
            // Scene
                // FXML
            FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("main-view.fxml")) ;
            try {
                Parent root = loader.load();
                Scene scene = new Scene(root,ventanaLogin.getWidth(), ventanaLogin.getHeight());
                ventanaLogin.setScene(scene);
                // ventanaMain.show();

                // ventanaLogin.close();
            } catch (IOException e) {
                System.out.println("Error en la carga de la parte grafica");
            }
        }
    }
}