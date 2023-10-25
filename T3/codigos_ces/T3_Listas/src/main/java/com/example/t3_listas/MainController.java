package com.example.t3_listas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private RadioMenuItem manuDeshabilitar;

    @FXML
    private MenuItem menuAlerta;

    @FXML
    private RadioMenuItem menuHabilitar;

    @FXML
    private MenuItem menuPregunta;

    @FXML
    private MenuItem menuSalir;

    @FXML
    private MenuItem menuSeleccion;

    @FXML
    private MenuItem menuSimple;

    @FXML
    private MenuItem menuTexto;

    @FXML
    private MenuItem menuWarn;

    @FXML
    private GridPane parteCentral;

    private ToggleGroup grupoHabilitar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarMenu();
        acciones();
    }

    private void personalizarMenu() {
        menuSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("out.png"))));
        menuSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        menuSalir.setMnemonicParsing(true);

    }

    private void acciones() {
        grupoHabilitar.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (((RadioMenuItem) t1).getText().equalsIgnoreCase("habilitar")){
                    parteCentral.setDisable(false);
                } else {
                    parteCentral.setDisable(true);
                }
            }
        });
        menuSalir.setOnAction(this);
        menuSimple.setOnAction(this);
        menuAlerta.setOnAction(this);
        menuWarn.setOnAction(this);
        menuSeleccion.setOnAction(this);
        menuPregunta.setOnAction(this);
        menuTexto.setOnAction(this);
    }

    private void instancias() {
        grupoHabilitar = new ToggleGroup();
        grupoHabilitar.getToggles().addAll(menuHabilitar, manuDeshabilitar);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == menuSalir){
            System.exit(0);
        } else if (actionEvent.getSource() == menuSimple){
            Alert alertSimple = new Alert(Alert.AlertType.INFORMATION);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de confirmacién simple");
            alertSimple.show();
        } else if (actionEvent.getSource() == menuWarn){
            Alert alertSimple = new Alert(Alert.AlertType.WARNING);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de warning");
            alertSimple.show();
        } else if (actionEvent.getSource() == menuAlerta){
            Alert alertSimple = new Alert(Alert.AlertType.ERROR);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de error");
            alertSimple.show();
        }

    }
}