package com.example.penstanias_ret;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonNormal, botonNormalDos;

    @FXML
    private ToggleButton toggle;

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
        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED,new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED,new ManejoRaton());
    }

    private void instancias() {

    }


    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            //System.out.println("Evento raton generado");
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                System.out.println("Evento raton entered");
                System.out.println(mouseEvent.getSceneX());
                System.out.println(mouseEvent.getSceneY());
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                System.out.println("Evento raton exited");
                System.out.println(mouseEvent.getSceneX());
                System.out.println(mouseEvent.getSceneY());
            }
        }
    }
    class ManejoPulsaciones implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Boton pulsado");
        }
    }
}
