package com.example.t4_comunicaciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {


    @FXML private Label labelStage2;
    @FXML private Button botonResponder;

    private MainController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        botonResponder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                // cierre
                ((Stage)botonResponder.getScene().getWindow()).close();
                controller.recepcionRespuesta("Texto de contestacion");
                // que pase los datos a la controladora que me ha llamado
                // ejecutando un método en el origen
                // accede a la controladora--> ejecutar el metodo
            }
        });


    }

    public void comunicarDatos(String texto){
        labelStage2.setText(texto);
        botonResponder.setDisable(true);
    }

    public void setControladora(MainController controller){
        this.controller = controller;
        botonResponder.setDisable(false);
    }


}
