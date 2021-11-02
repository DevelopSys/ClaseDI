package com.example.t_repaso;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<Event> {

    @FXML
    Button botonUno, botonDos, botonTres;
    @FXML
    TextField textoCentro;

    DropShadow dropShadow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();

        acciones();
    }

    private void personalizarBotones() {
        botonTres.setBackground(null);
        botonTres.setBorder(null);
        botonTres.setText("");
        botonTres.setGraphic(new ImageView(new Image(HelloController.class.getResourceAsStream("playbtn.png"))));

        botonDos.setBackground(null);
        botonDos.setBorder(null);
        botonDos.setText("");
        botonDos.setGraphic(new ImageView(new Image(HelloController.class.getResourceAsStream("playb.png"))));


    }

    private void instancias() {
        dropShadow = new DropShadow();
    }

    private void acciones() {
        /*botonUno.setOnAction(this);
        botonDos.setOnAction(this);
        botonTres.setOnAction(this);*/
        botonUno.addEventHandler(ActionEvent.ACTION, this);
        textoCentro.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                ((Event)keyEvent).consume();
            }
        });
        //botonUno.setOnMouseEntered(new ManejoRaton());
        botonUno.addEventHandler(MouseEvent.MOUSE_ENTERED, this);
        botonUno.setOnMouseExited(new ManejoRaton());
        botonDos.setOnMouseEntered(new ManejoRaton());
        botonDos.setOnMouseExited(new ManejoRaton());
        botonTres.setOnMouseEntered(new ManejoRaton());
        botonTres.setOnMouseExited(new ManejoRaton());
    }

    @Override
    public void handle(Event event) {
        if (event.getSource() == botonUno) {
            if (event.getEventType() == ActionEvent.ACTION) {
                // capturar el texto del campo de texto
                String textoCapturado = textoCentro.getText();
                System.out.println(textoCapturado);
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            // System.out.println("Pulsado boton");
            if (actionEvent.getSource() == botonUno) {
                System.out.println("Pulsado boton 1");
            } else {
                System.out.println("Pulsado boton 2 o 3");
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            Button btnAux = (Button) mouseEvent.getSource();

            // aplicar o no la sombra
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                btnAux.setEffect(null);
                //botonUno.setEffect(null);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                //botonUno.setEffect(dropShadow);
                btnAux.setEffect(dropShadow);
            }

            if (mouseEvent.getSource() == botonDos) {
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonDos.setGraphic(new ImageView(new Image(HelloController.class.getResourceAsStream("playre.png"))));

                } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                    botonDos.setGraphic(new ImageView(new Image(HelloController.class.getResourceAsStream("playb.png"))));

                }
            }


        }
    }
}

