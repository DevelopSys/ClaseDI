package com.example.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private MenuItem menuSalir, menuComunicarEspecifico, menuComunicaDefecto, menuEscena;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        personalizarBotones();
        acciones();

    }

    private void personalizarBotones() {
        menuComunicaDefecto.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("comunicar.png"))));
        menuComunicaDefecto.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        menuComunicarEspecifico.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("comunicar_esp.png"))));
        menuComunicarEspecifico.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
    }

    private void acciones() {
        menuSalir.setOnAction(new ManejoPulsaciones());
        menuComunicarEspecifico.setOnAction(new ManejoPulsaciones());
        menuComunicaDefecto.setOnAction(new ManejoPulsaciones());
        menuEscena.setOnAction(new ManejoPulsaciones());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuSalir){
                System.exit(0);
            } else if (actionEvent.getSource() == menuComunicaDefecto){

            }
        }
    }
}