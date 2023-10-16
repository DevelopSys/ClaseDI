package com.example.t2_layouts;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            // metodo ejecutado cuando se llama al atributo fx:controller
        personalizarBotones();
    }

    private void personalizarBotones() {
        // poner imagen a los botones
        botonTop.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("up.png"))));
        botonTop.setBackground(null);
        botonTop.setBorder(null);
        botonIzquierda.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("left.png"))));
        botonIzquierda.setBackground(null);
        botonIzquierda.setBorder(null);
        botonDerecha.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("rigth.png"))));
        botonDerecha.setBackground(null);
        botonDerecha.setBorder(null);
    }
}