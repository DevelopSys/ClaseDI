package com.example.iniciofx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    // variables

    @FXML
    private Label welcomeText;

    @FXML
    private Button botonPrueba;

    @FXML
    private CheckBox checkPrueba;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println(checkPrueba.isSelected());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Ejecucion desde el inicio del programa");
    }
}