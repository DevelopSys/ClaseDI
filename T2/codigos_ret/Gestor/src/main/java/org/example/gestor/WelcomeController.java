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

public class WelcomeController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    Button botonIniciar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonIniciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // stage -> scene -> FXML
                Stage ventaLogin = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("login-view.fxml"));
                Stage ventanaActual = (Stage) botonIniciar.getScene().getWindow();

                Parent root = null;
                try {
                    root = loader.load();
                    Scene scene = new Scene(root,
                            ventanaActual.getWidth(),
                            ventanaActual.getHeight());
                    ventaLogin.setScene(scene);
                    ventaLogin.show();
                    // stage -> close
                    ventanaActual.close();
                } catch (IOException e) {
                    System.out.println("Error en la carga del fichero");
                }
            }
        });
    }
}