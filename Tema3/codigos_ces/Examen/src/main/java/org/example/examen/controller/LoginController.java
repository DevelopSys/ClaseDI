package org.example.examen.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.examen.Launcher;
import org.example.examen.dao.UsuarioDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField inputCorreo, inputPass;
    @FXML
    private Button btnLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (inputCorreo.getText().isEmpty() || inputPass.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Falta datos");
                    alert.show();
                } else {
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    boolean estaUsuario = usuarioDAO.estaUsuario(inputCorreo.getText(), inputPass.getText());
                    if (estaUsuario){
                        Stage ventanaLisa = new Stage();
                        FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("lista-view.fxml"));
                        try {
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            ventanaLisa.setScene(scene);
                            ventanaLisa.show();
                            ((Stage)btnLogin.getScene().getWindow()).close();
                        } catch (IOException e) {
                            System.out.println("Localizacion incorrecta");
                        }

                    } else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Datos incorrectos");
                        alert.show();
                    }
                }
            }
        });

    }
}
