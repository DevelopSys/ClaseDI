package org.example.gestor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private Button btnConsulta;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnConsulta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // url -> "https://www.miapi/json/peticion"
                // httpConnection
                // bufferedReader
                
            }
        });
    }
}
