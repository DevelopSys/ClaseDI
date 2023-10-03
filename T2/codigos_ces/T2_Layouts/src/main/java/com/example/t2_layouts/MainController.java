package com.example.t2_layouts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent>{

    @FXML
    private BorderPane borderGeneral;

    @FXML
    private Button botonCentro;

    @FXML
    private Button botonDerecha;

    @FXML
    private Button botonIzquierda;

    @FXML
    private HBox parteDerecha;

    @FXML
    private HBox parteIzquierda;

    @FXML
    private HBox parteSuperior;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        personalizarBotones();
        acciones();




    }

    private void acciones() {
         /*botonCentro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Pulsado centro");
            }
        });
        botonIzquierda.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Pulsado izquierda");
            }
        });
        botonDerecha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Pulsado derecha");
            }
        });*/
        botonIzquierda.setOnAction(this);
        botonCentro.setOnAction(this);
        botonDerecha.setOnAction(this);
        botonIzquierda.setOnMouseEntered(new ManejoRaton());
        botonIzquierda.setOnMouseExited(new ManejoRaton());
    }

    private void personalizarBotones() {
        cambiarBoton(botonCentro,"up.png");
        cambiarBoton(botonIzquierda,"left.png");
        cambiarBoton(botonDerecha,"rigth.png");
    }

    private void cambiarBoton(Button boton, String imagen){
        boton.setText("");
        boton.setBackground(null);
        boton.setBorder(null);
        boton.setGraphic(
                new ImageView(new Image(getClass().getResourceAsStream(imagen))));
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("boton pulsado");
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            System.out.println("Raton entrado");
        }
    }
}