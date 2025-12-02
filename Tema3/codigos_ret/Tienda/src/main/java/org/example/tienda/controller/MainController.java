package org.example.tienda.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.tienda.dao.UsuarioDAO;
import org.example.tienda.dao.UsuarioDAOImp;
import org.example.tienda.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonAgregar, botonConsultar, botonBorrar, botonActualizar;
    private UsuarioDAOImp usuarioDAOImp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instancias();
        botonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                usuarioDAOImp.addUsuario(new Usuario("Borja","borja@gmail.com","1234",
                        1));
            }
        });

    }

    private void instancias() {
        usuarioDAOImp = new UsuarioDAOImp();
    }
}
