package com.example.repasocomunicacion_ret;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CorreoController implements Initializable {

    @FXML
    private TextField edit_correo;

    @FXML
    private Button boton_correo;

    private GeneralController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        boton_correo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.setCorreo(edit_correo.getText());
                ((Stage)boton_correo.getScene().getWindow()).close();
            }
        });
    }

    public void setController (GeneralController controller){
        this.controller = controller;
    }
}
