package org.example.inicio;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import org.example.inicio.model.Usuario;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FormularioController implements Initializable,
        EventHandler<ActionEvent> {

    @FXML
    private Button bEnviar, bLimpiar, bValidar, bSalir;
    @FXML
    private TextField editNombre, editApellido, editTelefono, editCorreo;
    @FXML
    private FlowPane layoutBotones, panelIzq, panelDer;
    @FXML
    private BorderPane panelGeneral;
    @FXML private Label labelIntentosNoOK, labelIntentosOK;

    private DropShadow sombra;
    private ArrayList<Usuario> listaUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ejecutado cuando fxmlloader.load()
        System.out.println("Ejecutada controladora");
        // panelGeneral.setLeft(null);
        // panelGeneral.setRight(null);
        instancias();
        persoGUI();
        acciones();
    }

    private void persoGUI() {
        persoBotones(bValidar, "validar.png");
        persoBotones(bEnviar, "enviar.png");
        persoBotones(bLimpiar, "borrarAA.png");
        persoBotones(bSalir, "exit.png");

    }

    private void persoBotones(Button boton, String path) {
        ImageView imagenEnviar;
        try {
            imagenEnviar =
                    new ImageView(new Image(
                            FormularioController.class.getResourceAsStream(path)));
        } catch (NullPointerException e) {
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
        listaUsuarios = new ArrayList<>();
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
        for (Node item : hijos) {
            setEventos((Button) item);
        }
    }

    private void setEventos(Button boton) {
        boton.setOnAction(this);
        boton.setOnMouseEntered(new MouseHandler());
        boton.setOnMouseExited(new MouseHandler());
        boton.setOnMousePressed(new MouseHandler());
        boton.setOnMouseReleased(new MouseHandler());
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource() == bEnviar) {
            // todos rellenos
            // correo con @
            if (editCorreo.getText().contains("@")
                    && !editCorreo.getText().isEmpty()
                    && !editNombre.getText().isEmpty()
                    && !editApellido.getText().isEmpty()
                    && !editTelefono.getText().isEmpty()
            ) {
                // añado un usuario a la lista
                listaUsuarios.add(new Usuario());
                labelIntentosOK.setText(String.valueOf(listaUsuarios.size()));
            } else {
                int intentos = Integer.parseInt(labelIntentosNoOK.getText())+1;
                labelIntentosNoOK.setText(String.valueOf(intentos));
            }
        } else if (actionEvent.getSource() == bLimpiar) {
            if (panelGeneral.getLeft() != null) {
                // quito
                panelGeneral.setLeft(null);
            } else {
                // pongo
                panelGeneral.setLeft(panelIzq);
            }
        } else if (actionEvent.getSource() == bValidar) {
            // poner o quitar
            if (panelGeneral.getRight() != null) {
                // quito
                panelGeneral.setRight(null);
            } else {
                // pongo
                panelGeneral.setRight(panelDer);
            }

        } else if (actionEvent.getSource() == bSalir) {
            System.out.println("Pulsado salir");
        }
    }

    class MouseHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                // PONER SOMBRA -> boton.setEffect(sombre)
                ((Button) (mouseEvent.getSource())).setEffect(sombra);
                ((Button) (mouseEvent.getSource())).setCursor(Cursor.HAND);

                // System.out.println("Raton entrando");
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                // System.out.println("Raton saliendo");
                // QUITAR SOMBRA -> boton.setEffect(null)
                ((Button) (mouseEvent.getSource())).setEffect(null);
                ((Button) (mouseEvent.getSource())).setCursor(Cursor.CROSSHAIR);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                System.out.println("El boton se esta soltando");
                if (mouseEvent.getSource() == bEnviar) {
                    persoBotones(bEnviar, "enviar.png");
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                System.out.println("El boton se esta pulsando");
                if (mouseEvent.getSource() == bEnviar) {
                    persoBotones(bEnviar, "default.png");
                }
            }
        }
    }
}
