package org.example.botones.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import org.example.botones.MyApplication;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    private Button boton1, boton2;
    @FXML
    private CheckBox check1, check2;
    @FXML
    private FlowPane flowRadios;
    @FXML
    private GridPane gridGeneral;
    @FXML
    private ImageView image;
    @FXML
    private TextArea textArea;
    @FXML
    private RadioButton radio1, radio2, radio3, radio4;
    @FXML
    private ToggleButton toggle;
    private ToggleGroup grupoRadios;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instances();
        initGUI();
        actions();
    }

    private void instances() {
        grupoRadios = new ToggleGroup();
    }

    private void actions() {
        /*check1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                toggle.setDisable(!newValue);
                textArea.appendText("Seleccion check "+newValue+"\n");
            }
        });
        toggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                check1.setDisable(!newValue);
                textArea.appendText("Seleccion toggle "+newValue+"\n");
            }
        });
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                // System.out.println(((RadioButton)newValue).getText());
                textArea.appendText(((RadioButton)newValue).getText()+"\n");
            }
        });*/
        boton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean estadoCheck = check1.isSelected();
                boolean estadoToggle = toggle.isSelected();
                RadioButton estadoGrupo = (RadioButton) grupoRadios.getSelectedToggle();
                textArea.appendText("Seleccion formulario\n");
                textArea.appendText("Check "+estadoCheck+"\n");
                textArea.appendText("Toggle "+estadoToggle+"\n");
                textArea.appendText("Grupo "+estadoGrupo.getText()+"\n");
            }
        });
    }


    private void initGUI() {

        textArea.setEditable(false);
        grupoRadios.getToggles().setAll(radio1,radio2,radio3,radio4);
        // al boton 1 le pongo una imagen
        configButton(boton1, "images/start.png");
        configButton(boton2, "images/stop.png");
    }

    private void configButton(Button button, String path) {

        button.setGraphic(new ImageView(
                new Image(Objects.requireNonNull(MyApplication.class.getResourceAsStream(path)))));
        button.setText("");
        button.setBackground(null);
        button.setBorder(null);
        button.setOnMouseEntered(new ManejoRaton());
        button.setOnMouseExited(new ManejoRaton());
        button.setOnMousePressed(new ManejoRaton());
        button.setOnMouseReleased(new ManejoRaton());

    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            Button button = (Button) event.getSource();
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                button.setEffect(new DropShadow());
                button.setCursor(Cursor.HAND);
            } else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                button.setCursor(Cursor.CLOSED_HAND);
            } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                button.setCursor(Cursor.OPEN_HAND);
            } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                button.setEffect(null);
                button.setCursor(Cursor.CROSSHAIR);
            }
        }
    }


}
