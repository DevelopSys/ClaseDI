package com.example.t_repaso;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<Event> {

    @FXML
    Button botonUno, botonDos, botonTres;

    DropShadow dropShadow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {
        dropShadow = new DropShadow();
    }

    public void acciones() {
        botonUno.setOnAction(this);
        botonDos.setOnAction(this);
        botonTres.setOnAction(this);
        botonUno.setOnMouseEntered(new ManejoMouse());
        botonUno.setOnMouseExited(new ManejoMouse());
    }

    @Override
    public void handle(Event event) {

    }


    class ManejoMouse implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getSource() == botonUno) {
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonUno.setEffect(dropShadow);

                } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                    botonUno.setEffect(null);
                }
            }
        }
    }
}