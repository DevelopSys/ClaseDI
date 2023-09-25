package com.example.t2_estructura;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText, secondText;

    @FXML
    private Button botonTercero;



    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onSecondButtonClick(){
        welcomeText.setText("Boton secundario pulsado");
    }

    @FXML
    protected void onMouseButton(){
        System.out.println("Raton pasando por el boton");
    }
}