package org.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormularioController implements Initializable {
    @FXML
    private Button botonBorrar,botonEnviar, botonValidar;

    @FXML
    private TextField editApellido, editCorreo,editNombre,editTelefono;

    @FXML
    private BorderPane layoutGeneral;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
