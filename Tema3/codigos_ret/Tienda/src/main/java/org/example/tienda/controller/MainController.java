package org.example.tienda.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import org.example.tienda.dao.UsuarioDAO;
import org.example.tienda.dao.UsuarioDAOImp;
import org.example.tienda.model.Usuario;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonAgregar, botonConsultar, botonBorrar, botonActualizar;
    private UsuarioDAOImp usuarioDAOImp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instancias();
        botonAgregar.setOnAction(new EventHandler<ActionEvent>() {

            // introducir un nuevo correo en caso de fallar
            // hay fallo?????
            @Override
            public void handle(ActionEvent event) {

                Usuario usuario = new Usuario("Borja", "borja@gmail.com", "1234",
                        1);
                boolean fallo = false;
                do {
                    try {
                        usuarioDAOImp.addUsuario(usuario);
                        fallo = false;
                    } catch (SQLException e) {
                        fallo = true;
                        // pedir mediante un alert de tipo prompt el nuevo correo
                        TextInputDialog textInputDialog = new TextInputDialog();
                        textInputDialog.setContentText("Introduce el nuevo correo");
                        textInputDialog.setTitle("Clave duplicada");
                        Optional<String> nuevoCorreo = textInputDialog.showAndWait();
                        String correoIntroducido = nuevoCorreo.get();
                        usuario.setCorreo(correoIntroducido);
                    }
                } while (fallo);

                // el usuario se ha agregado

            }


        });
        botonBorrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Borrado de usuarios");
                alert.setContentText("El numero de usuarios borrados es de "
                        + usuarioDAOImp.borrarUsuario("Borja"));
                alert.show();
                ;
            }
        });
        botonConsultar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<Usuario> lista = usuarioDAOImp.getUsuarios();
                for (Usuario item: lista) {
                    System.out.println(item.getNombre());
                }
            }
        });

    }

    private void instancias() {
        usuarioDAOImp = new UsuarioDAOImp();
    }
}
