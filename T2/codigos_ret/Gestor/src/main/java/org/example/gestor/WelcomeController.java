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
               Parent root = null;
               try {
                   root = loader.load();
               } catch (IOException e) {
                   System.out.println("Error en la carga del fichero");
               }
               Scene scene = new Scene(root,320,240);
               ventaLogin.setScene(scene);
               ventaLogin.show();
               // stage -> close
               Stage ventanaActual = (Stage) botonIniciar.getScene().getWindow();
               ventanaActual.close();
           }
       });
    }
}