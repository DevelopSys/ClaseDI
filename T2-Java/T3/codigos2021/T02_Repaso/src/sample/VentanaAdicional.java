package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaAdicional implements Initializable {

    @FXML
    Label texto_adicional;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void comunicarTexto(String texto){
        texto_adicional.setText(texto);
    }
}
