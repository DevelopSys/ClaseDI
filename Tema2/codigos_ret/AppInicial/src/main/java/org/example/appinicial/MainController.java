package org.example.appinicial;

import javafx.event.ActionEvent;
import javafx.event.Event;
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
    private Button botonEnviar, botonVaciar, botonLimpiar;

    @FXML
    private TextField textfieldNombre;

    @FXML
    private Label labelSaludo;

    private DropShadow sombra;

    // llamar a cada una de las variables de la parte grafica
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void initGUI() {
        botonEnviar.setEffect(null);
        botonVaciar.setEffect(null);
        botonLimpiar.setEffect(null);
    }

    private void instancias() {
        sombra = new DropShadow();
    }

    private void acciones() {
        /*botonEnviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (textfieldNombre.getText().isEmpty()) {
                    System.out.println("No puedes completar la tarea");
                } else {
                    labelSaludo.setText("Completo " + textfieldNombre.getText());
                    textfieldNombre.clear();
                }
            }
        });
        botonVaciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textfieldNombre.clear();
            }
        });
        botonLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelSaludo.setText("Primera APP Javafx");
            }
        });*/
        botonEnviar.setOnAction(new ManejadorAcciones());
        botonLimpiar.setOnAction(new ManejadorAcciones());
        botonVaciar.setOnAction(new ManejadorAcciones());
        /*
        botonEnviar.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // cuando el tipo de evento es enter
                botonEnviar.setEffect(sombra);
            }
        });
        botonEnviar.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // cuando el tipo de evento es exit
                botonEnviar.setEffect(null);
            }
        });
        */
        botonEnviar.setOnMouseEntered(new ManejadorRaton());
        botonLimpiar.setOnMouseEntered(new ManejadorRaton());
        botonEnviar.setOnMouseExited(new ManejadorRaton());
        botonLimpiar.setOnMouseExited(new ManejadorRaton());
        botonEnviar.setOnMousePressed(new ManejadorRaton());
        botonEnviar.setOnMouseReleased(new ManejadorRaton());
    }


    class ManejadorAcciones implements EventHandler<ActionEvent>{
        // el parametro actionEvent es el evento que se ha producido
        @Override
        public void handle(ActionEvent actionEvent) {
            // System.out.println("Boton pulsado correctamente");
            System.out.println("Boton pulsado, vamos a proceder a realizar llas acciones idndividuales");
            if (actionEvent.getSource()==botonEnviar){
                System.out.println("Boton enviar pulsado");
            } else if(actionEvent.getSource() == botonLimpiar){
                System.out.println("Boton limpiar pulsado");
            } else if(actionEvent.getSource()==botonVaciar){
                System.out.println("Boton vaciar pulsado");
            }
        }
    }
    class ManejadorRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {

            Button button = (Button) mouseEvent.getSource();
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                button.setEffect(sombra);
                if (button == botonEnviar){
                    button.setCursor(Cursor.HAND);
                }
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                button.setEffect(null);
                if (button==botonEnviar){
                    button.setCursor(Cursor.DEFAULT);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
                button.setCursor(Cursor.CLOSED_HAND);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED){
                button.setCursor(Cursor.HAND);
            }

        }
    }

    class ManejadorGeneral implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
            Button button = (Button) event.getSource();
        }
    }
}

// YO QUIERO QUE AL PASAR EL RATON PR ENCIMA SE PONGA LA SOMBRA
// AL SACAR EL RATON DE ENCIMA SE QUITA LA SOMBRA
