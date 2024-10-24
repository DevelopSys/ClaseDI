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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button btnAcceder;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField edCorreo;

    @FXML
    private TextField edPAss;

    @FXML
    private RadioButton radioInvitado;

    @FXML
    private RadioButton radioUsuario;

    @FXML
    private BorderPane root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
