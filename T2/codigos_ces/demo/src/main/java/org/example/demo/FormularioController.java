package org.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormularioController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button botonBorrar, botonEnviar, botonValidar, botonSalir;

    @FXML
    private TextField editApellido, editCorreo, editNombre, editTelefono;

    @FXML
    private BorderPane layoutGeneral;

    @FXML
    private FlowPane panelBotones;

    private DropShadow sombra;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        instancias();
        initGUI();
        acciones();
    }

    private void initGUI() {
        persoBoton(botonSalir,"exit.png");
        persoBoton(botonEnviar,"send.png");
        persoBoton(botonValidar,"ok.png");
        persoBoton(botonBorrar,"clear.png");
    }

    private void persoBoton(Button button, String path){
        ImageView imageView;
        try {
            imageView =
                    new ImageView(new Image(FormularioController.class.getResourceAsStream(path)));
        } catch (NullPointerException e) {
            imageView =
                    new ImageView(new Image(FormularioController.class.getResourceAsStream("default.png")));
        }

        button.setGraphic(imageView);
        button.setBackground(null);
    }

    private void instancias() {
        sombra = new DropShadow();
    }

    private void acciones() {

        for (Node item : panelBotones.getChildren()) {
            ((Button) item).setOnAction(this);
            item.setOnMouseEntered(new MouserEventHanlder()); // EventHandler<MouseEvent>
            item.setOnMouseExited(new MouserEventHanlder());  // EventHandler<MouseEvent>
        }
        /*
        botonBorrar.setOnAction(this);
        botonValidar.setOnAction(this);
        botonEnviar.setOnMouseEntered(new MouserEventHanlder()); // EventHandler<MouseEvent>
        botonBorrar.setOnMouseEntered(new MouserEventHanlder()); // EventHandler<MouseEvent>
        botonBorrar.setOnMouseExited(new MouserEventHanlder());  // EventHandler<MouseEvent>
        botonEnviar.setOnMouseExited(new MouserEventHanlder());  // EventHandler<MouseEvent>
        */

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource() instanceof Button) {
            Button button = (Button) actionEvent.getSource();
            System.out.println("Pulsado boton " + button.getText().toLowerCase());
        }

        /*if (actionEvent.getSource() == botonEnviar) {
            System.out.println("Pulsado enviar");
        } else if (actionEvent.getSource() == botonBorrar) {
            System.out.println("Pulsado borrar");
        } else if (actionEvent.getSource() == botonValidar) {
            System.out.println("Pulsado validar");
        } else if (actionEvent.getSource() == botonSalir) {
            System.out.println("Pulsado salir");
        }*/
    }

    // la clase que permite gestionar eventos de raton
    class MouserEventHanlder implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                /*if (mouseEvent.getSource() == botonValidar) {
                    botonValidar.setEffect(sombre);
                } else if (mouseEvent.getSource() == botonEnviar) {
                    botonEnviar.setEffect(sombre);
                } else if (mouseEvent.getSource() == botonBorrar) {
                    botonBorrar.setEffect(sombre);
                }*/
                //if (mouseEvent.getSource() instanceof Button) {
                //}
                ((Button) (mouseEvent.getSource())).setEffect(sombra);
                ((Button) (mouseEvent.getSource())).setCursor(Cursor.HAND);


            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                /*if (mouseEvent.getSource() == botonValidar) {
                    botonValidar.setEffect(null);
                } else if (mouseEvent.getSource() == botonEnviar) {
                    botonEnviar.setEffect(null);
                } else if (mouseEvent.getSource() == botonBorrar) {
                    botonBorrar.setEffect(null);
                }*/
                ((Button) (mouseEvent.getSource())).setEffect(null);
                ((Button) (mouseEvent.getSource())).setCursor(Cursor.CROSSHAIR);
            }
        }
    }
}
