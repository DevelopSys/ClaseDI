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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

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

    @FXML
    private GridPane parteInferior;

    private DropShadow sombra;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        borderGeneral.setLeft(null);
        borderGeneral.setRight(null);
        borderGeneral.setTop(null);
        personalizarBotones();

        acciones();
    }

    private void instancias() {
        sombra = new DropShadow();
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
        for (Node item : parteInferior.getChildren()) {

            if (item instanceof Button) {
                item.setOnMouseEntered(new ManejoRaton());
                item.setOnMouseExited(new ManejoRaton());
            }

        }
    }

    private void personalizarBotones() {
        cambiarBoton(botonCentro, "up.png");
        cambiarBoton(botonIzquierda, "left.png");
        cambiarBoton(botonDerecha, "rigth.png");
    }

    private void cambiarBoton(Button boton, String imagen) {
        boton.setText("");
        boton.setBackground(null);
        boton.setBorder(null);
        boton.setGraphic(
                new ImageView(new Image(getClass().getResourceAsStream(imagen))));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonDerecha) {
            if (borderGeneral.getRight() == null) {
                borderGeneral.setRight(parteDerecha);
            } else {
                borderGeneral.setRight(null);
            }
        } else if (actionEvent.getSource() == botonCentro) {
            if (borderGeneral.getTop() == null) {
                borderGeneral.setTop(parteSuperior);
            } else {
                borderGeneral.setTop(null);
            }
        } else if (actionEvent.getSource() == botonIzquierda) {
            System.out.println("Pulsado boton izquierda");
            if (borderGeneral.getLeft() == null) {
                borderGeneral.setLeft(parteIzquierda);
            } else {
                borderGeneral.setLeft(null);
            }

        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) (mouseEvent.getSource())).setEffect(null);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                ((Button) (mouseEvent.getSource())).setEffect(sombra);
            }
        }
    }


}