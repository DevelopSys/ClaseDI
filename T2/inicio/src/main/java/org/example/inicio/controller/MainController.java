package org.example.inicio.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextField editNombre;

    @FXML
    private Button btnSaludar, btnVaciar, btnSalir;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Inicializando la parte logica");
        instances();
        initGUI();
        actions();

    }

    private void instances() {
    }

    private void initGUI() {
    }

    private void actions() {

        btnSaludar.setOnAction(new ManejoPulsaciones());
        btnVaciar.setOnAction(new ManejoPulsaciones());
        btnSalir.setOnAction(new ManejoPulsaciones());

        btnSaludar.setOnMouseEntered(event -> {
            System.out.println("Raton por encima");
            btnSaludar.setCursor(Cursor.HAND);
        });
        /*btnSaludar.setOnMouseExited(event -> {
            System.out.println("Raton saliendo");
            btnSaludar.setCursor(Cursor.CROSSHAIR);
        });*/
        btnSaludar.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            System.out.println("Raton saliendo");
            btnSaludar.setCursor(Cursor.CROSSHAIR);
        });

    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Pulsacion generica");
            if(event.getSource() == btnSalir){
                
            }
        }
    }
    class ManejoRaton implements  EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent event) {

        }
    }


}
