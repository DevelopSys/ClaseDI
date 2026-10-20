package org.example.tiendaapp.controller;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button botonLogin, botonRegistro;

    @FXML
    private CheckBox checkRecordar;

    @FXML
    private TextField editCorreo, editPass;

    @FXML
    private Text textWarning;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
