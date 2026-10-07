package org.example.inicio.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    FlowPane flowPane;

    @FXML
    private TextField editNombre;

    @FXML
    private Button btnSaludar, btnVaciar, btnSalir;
    private DropShadow shadow;

    @FXML
    private Text textNombre;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Inicializando la parte logica");
        instances();
        initGUI();
        actions();

    }

    private void instances() {
        shadow = new DropShadow();
    }

    private void initGUI() {
        borderPane.setRight(null);
    }

    private void actions() {

        btnSaludar.setOnAction(evet ->
        {
            if (borderPane.getRight() == null) {
                borderPane.setRight(flowPane);
            }
            String nombre = editNombre.getText();
            // System.out.printf("Enhorabuena %s has completado el reto", nombre);
            textNombre.setText(textNombre.getText() + "\n" + nombre);
            editNombre.clear();
        });
        btnVaciar.setOnAction(event ->
                editNombre.clear()
        );
        btnSalir.setOnAction(evet -> System.exit(0));

        btnSaludar.setOnMouseEntered(new ManejoRaton());
        btnSaludar.setOnMouseExited(new ManejoRaton());
        btnSalir.setOnMouseEntered(new ManejoRaton());
        btnSalir.setOnMouseExited(new ManejoRaton());
        btnVaciar.setOnMouseEntered(new ManejoRaton());
        btnVaciar.setOnMouseExited(new ManejoRaton());


    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Pulsacion generica");
            if (event.getSource() == btnSalir) {

            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            Button buttonEvent = (Button) event.getSource();
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                buttonEvent.setCursor(Cursor.HAND);
                buttonEvent.setEffect(shadow);
            } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                buttonEvent.setCursor(Cursor.CROSSHAIR);
                buttonEvent.setEffect(null);
            }
        }
    }


}
