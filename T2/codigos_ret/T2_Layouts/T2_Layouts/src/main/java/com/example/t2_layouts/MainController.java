package com.example.t2_layouts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private BorderPane borderGeneral;

    @FXML
    private Button botonDerecha;

    @FXML
    private Button botonIzquierda;

    @FXML
    private Button botonTop;

    @FXML
    private VBox parteDerecha;

    @FXML
    private HBox parteInferior;

    @FXML
    private VBox parteIzquerda;

    @FXML
    private HBox parteSuperior;

    private DropShadow sombra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // metodo ejecutado cuando se llama al atributo fx:controller
        instancias();
        personalizarBotones();
        acciones();
    }

    private void instancias() {
        sombra = new DropShadow();
        //  MouseEntered --> pasa por encima
        //  MouseExited --> sale de encima
    }

    private void acciones() {

        for (Node item : parteInferior.getChildren()) {
            if (item instanceof Button) {
                ((Button) item).setOnAction(this);
                ((Button) item).setOnMouseEntered(new ManejoRaton());
                ((Button) item).setOnMouseExited(new ManejoRaton());
            }
        }

        /*botonIzquierda.setOnAction(this);
        botonDerecha.setOnAction(this);
        botonDerecha.setOnMouseEntered(new ManejoRaton());
        botonDerecha.setOnMouseExited(new ManejoRaton());
        botonTop.setOnMouseEntered(new ManejoRaton());
        botonTop.setOnMouseExited(new ManejoRaton());*/
    } 

    private void personalizarBotones() {
        // poner imagen a los botones
        cambiarAspectoBotones(botonTop, "up.png");
        cambiarAspectoBotones(botonIzquierda, "left.png");
        cambiarAspectoBotones(botonDerecha, "rigth.png");
    }

    private void cambiarAspectoBotones(Button boton, String imagen) {
        boton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(imagen))));
        boton.setBackground(null);
        boton.setBorder(null);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonIzquierda) {
            if (borderGeneral.getLeft() == null) {
                // si no hay parte izq
                borderGeneral.setLeft(parteIzquerda);
            } else {
                // si hay parte izq
                borderGeneral.setLeft(null);
            }

        } else if (actionEvent.getSource() == botonDerecha) {
            if (borderGeneral.getRight() == null) {
                // si no hay parte izq
                borderGeneral.setRight(parteDerecha);
            } else {
                // si hay parte izq
                borderGeneral.setRight(null);
            }
        } else if (actionEvent.getSource() == botonTop) {
            if (borderGeneral.getTop() == null) {
                // si no hay parte izq
                borderGeneral.setTop(parteSuperior);
            } else {
                // si hay parte izq
                borderGeneral.setTop(null);
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                /*if (mouseEvent.getSource() == botonIzquierda){
                    botonIzquierda.setEffect(sombra);
                } else if (mouseEvent.getSource() == botonDerecha){
                    botonDerecha.setEffect(sombra);
                } else if (mouseEvent.getSource() == botonTop){
                    botonTop.setEffect(sombra);
                }*/
                ((Button) mouseEvent.getSource()).setEffect(sombra);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                /*if (mouseEvent.getSource() == botonIzquierda){
                    botonIzquierda.setEffect(null);
                } else if (mouseEvent.getSource() == botonDerecha){
                    botonDerecha.setEffect(null);
                } else if (mouseEvent.getSource() == botonTop){
                    botonTop.setEffect(null);
                }*/
                ((Button) mouseEvent.getSource()).setEffect(null);
            }
        }
    }
}