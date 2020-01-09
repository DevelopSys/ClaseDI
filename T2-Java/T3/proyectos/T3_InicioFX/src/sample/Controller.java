package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button botonNormal;

    @FXML
    JFXButton botonMaterial;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        acciones();

    }

    private void acciones() {

        /*botonNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("botón pulsado");
            }
        });*/

        /*botonNormal.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("botón pulsado");
            }
        });*/


        /*botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("ratón encima");
            }
        });

        botonNormal.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("botón pulsado");
            }
        });*/

        botonNormal.addEventHandler(ActionEvent.ACTION, new ManejadorPulsaciones());
        botonMaterial.addEventHandler(ActionEvent.ACTION, new ManejadorPulsaciones());
    }

    class ManejadorPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == botonNormal) {
                System.out.println("boton normal");
            } else if (event.getSource() == botonMaterial) {
                System.out.println("boton material");
            }
        }
    }
}
