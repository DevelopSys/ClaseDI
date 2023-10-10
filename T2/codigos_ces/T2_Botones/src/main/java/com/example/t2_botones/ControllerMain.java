package com.example.t2_botones;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button botonGeneral;

    @FXML
    private Button botonImagen;

    @FXML
    private Button botonNormal;

    @FXML
    private Button botonURL, botonComprobar;

    @FXML
    private Tab botonesCompuestos;

    @FXML
    private Tab botonesNormales;


    @FXML
    private CheckBox check1;

    @FXML
    private CheckBox check2;

    @FXML
    private CheckBox check3;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private ToggleButton toggle1;

    @FXML
    private ToggleButton toggle2;

    @FXML
    private ToggleButton toggle3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        personalizarBotones();
        acciones();

    }

    private void personalizarBotones() {
        botonImagen.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("button.png"))));
        botonImagen.setBackground(null);
        botonImagen.setBorder(null);

        botonURL.setGraphic(new ImageView(new Image("https://www.shutterstock.com/image-vector/golden-close-button-game-interface-260nw-2178668753.jpg")));
        botonURL.setBackground(null);
        botonURL.setBorder(null);
    }

    private void acciones() {
        toggle1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean old, Boolean newValue) {
                if (newValue){
                    System.out.println("Elemento seleccionado");
                    //toggle1.setGraphic(new ImageView(new Image()));
                } else {
                    System.out.println("Elemento deseleccionado");
                    //toggle1.setGraphic(new ImageView(new Image()));
                }
            }
        });
        botonNormal.setOnAction(this);
        botonImagen.setOnAction(this);
        botonURL.setOnAction(this);
        botonGeneral.setOnAction(this);
        botonComprobar.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonComprobar){
            toggle1.setSelected(true);
        }
        else if (actionEvent.getSource() == botonNormal){

        } else if (actionEvent.getSource() == botonImagen){

        } else if (actionEvent.getSource() == botonURL){

        } else if (actionEvent.getSource() == botonGeneral){

        }
    }

}