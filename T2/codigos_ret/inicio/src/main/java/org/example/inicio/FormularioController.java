package org.example.inicio;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormularioController implements Initializable {

    @FXML
    private Button bEnviar, bLimpiar, bValidar;
    @FXML
    private TextField editNombre, editApellido, editTelefono, editCorreo;
    @FXML
    private FlowPane layoutBotones;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ejecutado cuando fxmlloader.load()

    }
}
