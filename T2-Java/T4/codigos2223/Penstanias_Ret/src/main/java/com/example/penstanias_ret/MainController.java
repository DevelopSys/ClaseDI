package com.example.penstanias_ret;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonNormal, botonNormalDos;

    @FXML
    private ToggleButton toggle;

    private DropShadow sombreExterior;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        acciones();
    }

    private void acciones() {
        // acciones
        // directa setOnEvento setOnAction --> EventHander<ActionEvent>

        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());

        toggle.setOnAction(new ManejoPulsaciones());

        toggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {
                botonNormal.setDisable(toggle.isSelected());
                botonNormalDos.setDisable(toggle.isSelected());
            }
        });

        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());


    }

    private void instancias() {
        sombreExterior = new DropShadow();
    }


    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            //System.out.println("Evento raton generado");
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                ((Button) mouseEvent.getSource()).setEffect(sombreExterior);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) mouseEvent.getSource()).setEffect(null);
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource() == toggle) {
                botonNormal.setDisable(toggle.isSelected());
                botonNormalDos.setDisable(toggle.isSelected());
            } else if (actionEvent.getSource() == botonNormal) {
                toggle.setSelected(true);
            } else if (actionEvent.getSource() == botonNormalDos) {
                toggle.setSelected(false);
            }

        }
    }
}
