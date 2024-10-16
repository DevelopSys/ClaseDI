package org.example.inicio;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormularioController implements Initializable,
        EventHandler<ActionEvent> {

    @FXML
    private Button bEnviar, bLimpiar, bValidar;
    @FXML
    private TextField editNombre, editApellido, editTelefono, editCorreo;
    @FXML
    private FlowPane layoutBotones, panelIzq, panelDer;
    @FXML
    private BorderPane panelGeneral;

    private DropShadow sombra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        // ejecutado cuando fxmlloader.load()
        System.out.println("Ejecutada controladora");
        panelGeneral.setLeft(null);
        panelGeneral.setRight(null);
        instancias();
        persoGUI();
        acciones();
    }

    private void persoGUI() {
    persoBotones(bValidar,"validar.png");
    persoBotones(bEnviar,"enviar.png");
    persoBotones(bLimpiar,"borrarAA.png");

    }

    private void persoBotones(Button boton, String path)
    {
        ImageView imagenEnviar;
        try{
            imagenEnviar =
                    new ImageView(new Image(
                            FormularioController.class.getResourceAsStream(path)));
        }catch (NullPointerException e){
            imagenEnviar =
                    new ImageView(new Image(
                            FormularioController.class.getResourceAsStream("default.png")));
        }
        boton.setText(null);
        boton.setBackground(null);
        boton.setGraphic(imagenEnviar);
    }


    private void instancias() {
        sombra = new DropShadow();
    }
    private void acciones() {

        // al pasar por encima de un boton se ensombrece
        // al salir de un boton, se quita la sombra

        //bEnviar.setOnAction(this);
        // bLimpiar.setOnAction(this);
        // bValidar.setOnAction(this);
        // bEnviar.setOnMouseEntered(new MouseHandler());
        // bValidar.setOnMouseEntered(new MouseHandler());
        // bLimpiar.setOnMouseEntered(new MouseHandler());
        // bEnviar.setOnMouseExited(new MouseHandler());
        // bLimpiar.setOnMouseExited(new MouseHandler());
        // bValidar.setOnMouseExited(new MouseHandler());
        // setEventos(bEnviar);
        // setEventos(bLimpiar);
        // setEventos(bValidar);
        ObservableList<Node> hijos = layoutBotones.getChildren();
        for ( Node item : hijos ) {
            setEventos((Button) item);
        }
    }

    private void setEventos(Button boton){
        boton.setOnAction(this);
        boton.setOnMouseEntered(new MouseHandler());
        boton.setOnMouseExited(new MouseHandler());
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource() == bEnviar){
            System.out.println("Pulsado enviar");
        } else if (actionEvent.getSource() == bLimpiar) {
            System.out.println("Pulsado limpiar");
        } else if (actionEvent.getSource() == bValidar) {
            System.out.println("Pulsado validar");
        }
    }
    class MouseHandler implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                // PONER SOMBRA -> boton.setEffect(sombre)
                ((Button)(mouseEvent.getSource())).setEffect(sombra);
                // System.out.println("Raton entrando");
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                // System.out.println("Raton saliendo");
                // QUITAR SOMBRA -> boton.setEffect(null)
                ((Button)(mouseEvent.getSource())).setEffect(null);
            }
        }
    }
}