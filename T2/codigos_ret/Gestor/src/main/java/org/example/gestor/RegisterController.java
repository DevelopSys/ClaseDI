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

public class RegisterController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private TextField editNombre, editApellido, editPass1, editPass2, editCorreo;
    @FXML
    private RadioButton radioMasculino, radioFemenino;
    @FXML
    Button btnRegistrar, btnVolver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnVolver.setOnAction(this);
        btnRegistrar.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource() == btnVolver) {
            Stage actual = (Stage) btnVolver.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            try {
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root, 400, 300);
                actual.setHeight(root.prefHeight(-1));
                actual.setWidth(root.prefWidth(-1));
                actual.setResizable(false);
                actual.setScene(scene);
                actual.setTitle("Login");
            } catch (IOException e) {
                System.out.println("No encuentro la vista");
            }
        } else {
            if (!editApellido.getText().isEmpty()
                    && !editCorreo.getText().isEmpty()
                    && !editNombre.getText().isEmpty()
                    && !editPass1.getText().isEmpty()
                    && (editPass1.getText().equalsIgnoreCase(editPass2.getText()))
            ){
                new DataBase().agregarUsuario(new Usuario());
                new DataBase().agregarUsuario(new Usuario());
                new DataBase().agregarUsuario(new Usuario());
                new DataBase().agregarUsuario(new Usuario());
                new DataBase().agregarUsuario(new Usuario());
                new DataBase().agregarUsuario(new Usuario());
            }
        }
    }
}