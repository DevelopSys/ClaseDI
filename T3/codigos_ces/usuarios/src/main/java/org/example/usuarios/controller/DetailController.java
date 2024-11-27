package org.example.usuarios.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.example.usuarios.dao.UsuarioDAO;
import org.example.usuarios.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {
    @FXML
    public Label textoId;
    @FXML
    public Label textoMail;
    @FXML
    public Label textoPass;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setUsuario(Usuario usuario){
        textoId.setText(String.valueOf(usuario.getId()));
        textoMail.setText(String.valueOf(usuario.getCorreo()));
        textoPass.setText(String.valueOf(usuario.getPass()));
    }
}
