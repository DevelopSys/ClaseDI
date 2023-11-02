package com.example.t3_listas;

import com.example.t3_listas.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import net.synedra.validatorfx.Check;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoController implements Initializable {

    @FXML
    private TextField textoNombre, textoPass, textoCorreo;

    @FXML
    private CheckBox checkRecordar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public boolean isUsuario() {

        if (textoCorreo.getText().isEmpty() || textoNombre.getText().isEmpty()
                || textoPass.getText().isEmpty()) {
            return false;
        }

        return true;
    }

    public Usuario getUsuario() {
        return new Usuario(textoNombre.getText(), textoPass.getText(), textoCorreo.getText());
    }
}
