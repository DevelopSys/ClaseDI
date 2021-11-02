package com.example.t_repaso;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<Event> {

    @FXML
    Button botonUno, botonDos, botonTres;

    @FXML
    TextField textoInicial;

    DropShadow dropShadow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();
        acciones();
    }

    private void personalizarBotones() {
        botonUno.setBackground(null);
        botonUno.setBorder(null);
        botonUno.setGraphic(new ImageView(new Image(HelloApplication.class.getResourceAsStream("playg.png"))));

    }

    private void instancias() {
        dropShadow = new DropShadow();
    }

    public void acciones() {
        /*botonUno.setOnAction(this);
        botonDos.setOnAction(this);
        botonTres.setOnAction(this);
        botonUno.setOnMouseEntered(this);
        botonUno.setOnMouseExited(this);*/
        botonUno.addEventHandler(MouseEvent.MOUSE_ENTERED, this);
        botonUno.addEventHandler(MouseEvent.MOUSE_EXITED, this);
        botonDos.addEventHandler(MouseEvent.MOUSE_ENTERED, this);
        botonDos.addEventHandler(MouseEvent.MOUSE_EXITED, this);
        botonTres.addEventHandler(MouseEvent.MOUSE_ENTERED, this);
        botonTres.addEventHandler(MouseEvent.MOUSE_EXITED, this);
        botonUno.addEventHandler(ActionEvent.ACTION, this);
        botonDos.addEventHandler(ActionEvent.ACTION, this);
        botonTres.addEventHandler(ActionEvent.ACTION, this);
        textoInicial.addEventHandler(KeyEvent.KEY_RELEASED,this);

    }

    @Override
    public void handle(Event event) {

        if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {

            ((Button)event.getSource()).setEffect(dropShadow);
            ((Button)event.getSource()).setGraphic(new ImageView(new Image(HelloApplication.class.getResourceAsStream("playr.png"))));

        } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
            ((Button)event.getSource()).setGraphic(new ImageView(new Image(HelloApplication.class.getResourceAsStream("playg.png"))));

            ((Button)event.getSource()).setEffect(null);
        } else if (event.getEventType() == ActionEvent.ACTION) {

            System.out.println("Pulsado " + ((Button)event.getSource()).getText());
        } else if (event.getEventType() == KeyEvent.KEY_RELEASED){
            System.out.println(((KeyEvent)event).getText());
            //System.out.println("Elemento");
            if (textoInicial.getText().length()>10){
                //System.out.println(((KeyEvent)event).getText());
                event.consume();
            }
        }
    }


    class ManejoMouse implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getSource() == botonUno) {
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonUno.setEffect(dropShadow);

                } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                    botonUno.setEffect(null);
                }
            }
        }
    }
}