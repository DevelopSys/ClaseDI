package org.example.formularioapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.formularioapp.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoController implements Initializable {

    @FXML
    Label textoNombre, textoLocalizacion, textoGenero, textoEdad, textoMail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setUsuario(Usuario usuario){
        textoNombre.setText(usuario.getNombre());
        textoMail.setText(usuario.getCorreo());
        textoGenero.setText(usuario.getGenero());
        textoEdad.setText(String.valueOf(usuario.getEdad()));
        textoLocalizacion.setText(usuario.getLocalizacion());
    }
}
