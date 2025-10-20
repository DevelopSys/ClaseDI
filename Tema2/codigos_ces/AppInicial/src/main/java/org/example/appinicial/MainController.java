package org.example.appinicial;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button buttonPulsar, buttonVaciar;

    @FXML
    private Label labelSaludo;

    @FXML
    private TextField textfieldNombre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Ejecutado directamente en la asociacion de la stage

        acciones();
    }

    private void acciones() {

        /*
        buttonVaciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelSaludo.setText("");
                textfieldNombre.clear();
            }
        });

        buttonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // el metodo a ejecutar cuando el boton sea pulsado

                // al pulsar el boton se capture el texto que esta en el textfield y se ponga en el label
                // el mensaje de "Enhorabuena Borja, has completado el primer ejercicio"
                // System.out.println("Boton pulsado correctamente");
                String nombre = textfieldNombre.getText();
                if (nombre.isBlank()){
                    System.out.println("Por favor rellena el nombre");
                } else {
                    labelSaludo.setText(String.format("Enhorabuena %s has completado el 1er ejercicio", nombre));
                    textfieldNombre.clear();
                }
            }
        });
         */

        buttonVaciar.setOnAction(new ManejoAccion());
        buttonPulsar.setOnAction(new ManejoAccion());
    }


    class ManejoAccion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsado boton");
            // que boton se ha pulsado?
            if (actionEvent.getSource()==buttonPulsar){

            } else if (actionEvent.getSource()==buttonVaciar){

            }
        }
    }
}
