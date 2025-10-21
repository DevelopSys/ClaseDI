package org.example.appinicial;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button buttonPulsar, buttonVaciar, buttonLimpiar;

    @FXML
    private Label labelSaludo;

    @FXML
    private TextField textfieldNombre;

    private DropShadow sombra;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Ejecutado directamente en la asociacion de la stage
        instancias();
        initGUI();

        acciones();
    }

    private void initGUI() {
        // personalizara las partes de la UI
        // buttonPulsar.setEffect(sombra);
    }

    private void instancias() {
        sombra = new DropShadow();
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

        // buttonPulsar.setOnMouseExited(mouseEvent -> buttonPulsar.setEffect(null));
        buttonPulsar.setOnMousePressed(new ManejoRaton());
        buttonPulsar.setOnMouseReleased(new ManejoRaton());
        buttonPulsar.setOnMouseExited(new ManejoRaton());
        buttonPulsar.setOnMouseEntered(new ManejoRaton());
        buttonVaciar.setOnMouseExited(new ManejoRaton());
        buttonVaciar.setOnMouseEntered(new ManejoRaton());
        buttonLimpiar.addEventHandler(ActionEvent.ACTION,new ManejoAccion());

    }


    class ManejoAccion implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsado boton");
            // que boton se ha pulsado?
            if (actionEvent.getSource() == buttonPulsar) {
                String nombre = textfieldNombre.getText();
                if (nombre.isBlank()) {
                    System.out.println("Por favor rellena el nombre");
                } else {
                    labelSaludo.setText(String.format("Enhorabuena %s has completado el 1er ejercicio", nombre));
                    textfieldNombre.clear();
                }
            } else if (actionEvent.getSource() == buttonVaciar) {
                labelSaludo.setText("");
                textfieldNombre.clear();
            } else if (actionEvent.getSource() == buttonLimpiar) {
                textfieldNombre.clear();
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            Button boton = (Button) mouseEvent.getSource();
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                boton.setEffect(sombra);
                if (boton == buttonPulsar){
                    boton.setCursor(Cursor.OPEN_HAND);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                boton.setEffect(null);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                buttonPulsar.setCursor(Cursor.CLOSED_HAND);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                buttonPulsar.setCursor(Cursor.OPEN_HAND);
            }
        }
    }

}

