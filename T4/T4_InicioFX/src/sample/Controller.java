package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Label labelInicial;

    @FXML
    Button botonInicio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelInicial.setText("Label modificada desde texto");
    }
}
