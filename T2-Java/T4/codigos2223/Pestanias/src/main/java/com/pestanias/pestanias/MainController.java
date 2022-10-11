package com.pestanias.pestanias;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.glyphfont.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // elementos gráficos
    @FXML
    private TabPane panelPestanias;
    @FXML
    private Button botonNormal, botonNormalDos;
    @FXML
    private ToggleButton botonToggle;

    private DropShadow sombraExterior;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // se ejecuca cuando se asocia la parte grafica y la logica --> setContentView


        instancias();
        configurarBotones();
        acciones();


    }

    private void configurarBotones() {
        // ImageView --> Image
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);

        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);
    }

    private void instancias() {
        sombraExterior = new DropShadow();
    }

    private void acciones() {
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        botonToggle.setOnAction(new ManejoPulsaciones());

        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());

        //botonNormal.addEventHandler(MouseEvent.MOUSE_RELEASED, new ManejoRaton());
    }

    class ManejoRaton implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(sombraExterior);
                } else if (mouseEvent.getSource() == botonNormalDos){
                    botonNormalDos.setEffect(sombraExterior);
                }
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(null);
                } else if (mouseEvent.getSource() == botonNormalDos){
                    botonNormalDos.setEffect(null);
                }
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
                //System.out.println("Raton pressed");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                System.out.println("Raton clicked");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED){
                System.out.println("Raton released");
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            //System.out.println("Boton pulsado");
            if (actionEvent.getSource() == botonNormal){

            } else if (actionEvent.getSource() == botonNormalDos){

            } else if (actionEvent.getSource() == botonToggle){
                System.out.println("toggle pulsado");
                System.out.println(botonToggle.isSelected());
                // activar los dos botones si el toggle esta true
                // desactivar los dos botones si el toggle esta false
            }
        }
    }
}
