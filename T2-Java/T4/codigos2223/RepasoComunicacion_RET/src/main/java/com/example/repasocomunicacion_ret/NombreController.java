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

public class NombreController implements Initializable {

    @FXML
    private Button boton_nombre;

    @FXML
    private TextField edit_nombre;

    private GeneralController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boton_nombre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // darle los datos a la controladora uno
                controller.setNombre(edit_nombre.getText());
                // cerrar ventana
                ((Stage)boton_nombre.getScene().getWindow()).close();
            }
        });
    }

    public void setController(GeneralController controller) {
        this.controller = controller;
    }
}
