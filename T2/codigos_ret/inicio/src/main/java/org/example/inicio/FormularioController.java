package org.example.inicio;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormularioController implements Initializable,
        EventHandler<ActionEvent> {

    @FXML
    private Button bEnviar, bLimpiar, bValidar;
    @FXML
    private TextField editNombre, editApellido, editTelefono, editCorreo;
    @FXML
    private FlowPane layoutBotones;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        // ejecutado cuando fxmlloader.load()
        System.out.println("Ejecutada controladora");
        acciones();

    }

    private void acciones() {
        bEnviar.setOnAction(this);
        bLimpiar.setOnAction(this);
        bValidar.setOnAction(this);
        bEnviar.setOnMouseEntered(new MouseHandler());
        bEnviar.setOnMouseExited(new MouseHandler());
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource() == bEnviar){
            System.out.println("Pulsado enviar");
        } else if (actionEvent.getSource() == bLimpiar) {
            System.out.println("Pulsado limpiar");
        } else if (actionEvent.getSource() == bValidar) {
            System.out.println("Pulsado validar");
        }
    }

    class MouseHandler implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("Raton detectado");
        }
    }
}
