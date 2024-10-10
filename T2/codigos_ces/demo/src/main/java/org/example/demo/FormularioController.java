package org.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormularioController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button botonBorrar,botonEnviar, botonValidar;

    @FXML
    private TextField editApellido, editCorreo,editNombre,editTelefono;

    @FXML
    private BorderPane layoutGeneral;

    private DropShadow sombre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sombre = new DropShadow();
        botonEnviar.setEffect(sombre);

        acciones();
    }

    private void acciones() {
        botonEnviar.setOnAction(this);
        botonBorrar.setOnAction(this);
        botonValidar.setOnAction(this);
        botonValidar.setOnMouseEntered(this);
        botonValidar.setOnMouseExited(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonEnviar){
            System.out.println("Pulsado enviar");
        } else if (actionEvent.getSource() == botonBorrar) {
            System.out.println("Pulsado borrar");
        } else if (actionEvent.getSource() == botonValidar) {
            System.out.println("Pulsado validar");
        }
    }
}
