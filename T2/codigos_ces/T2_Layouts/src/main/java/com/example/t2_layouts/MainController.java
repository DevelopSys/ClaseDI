package com.example.t2_layouts;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

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

        botonCentro.setOnAction(new EventHandler<ActionEvent>() {
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
        });



    }


}