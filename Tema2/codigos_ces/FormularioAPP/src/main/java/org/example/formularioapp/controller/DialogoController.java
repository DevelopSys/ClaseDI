package org.example.formularioapp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.formularioapp.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoController implements Initializable {

    @FXML
    private Label textoNombre, textoLocalizacion, textoGenero, textoEdad, textoMail;

    @FXML
    private Button botonContestar;

    private FormController formController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        botonContestar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Pulsado el contestar");
                formController.actualizarUsuario(null);
                ((Stage)botonContestar.getScene().getWindow()).close();
            }
        });
    }

    public void setFormController(FormController controller){
        this.formController = controller;
    }

    public void setUsuario(Usuario usuario){
        textoNombre.setText(usuario.getNombre());
        textoMail.setText(usuario.getCorreo());
        textoGenero.setText(usuario.getGenero());
        textoEdad.setText(String.valueOf(usuario.getEdad()));
        textoLocalizacion.setText(usuario.getLocalizacion());
    }
}
