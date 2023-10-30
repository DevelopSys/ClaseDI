package com.example.t3_listas;

import com.example.t3_listas.model.Pelicula;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
                if (((RadioMenuItem) t1).getText().equalsIgnoreCase("habilitar")) {
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
        if (actionEvent.getSource() == menuSalir) {
            System.exit(0);
        } else if (actionEvent.getSource() == menuSimple) {
            Alert alertSimple = new Alert(Alert.AlertType.INFORMATION);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de confirmacién simple");
            alertSimple.show();
        } else if (actionEvent.getSource() == menuWarn) {
            Alert alertSimple = new Alert(Alert.AlertType.WARNING);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de warning");
            alertSimple.show();
        } else if (actionEvent.getSource() == menuAlerta) {
            Alert alertSimple = new Alert(Alert.AlertType.ERROR);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de error");
            alertSimple.show();
        } else if (actionEvent.getSource() == menuPregunta) {
            Alert dialgoPregunta = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType botonUno = new ButtonType("Preguntar mas tarde");
            ButtonType botonDos = new ButtonType("Aplicar y esperar");
            //dialgoPregunta.getButtonTypes().addAll(botonUno,botonDos, ButtonType.APPLY);
            dialgoPregunta.getButtonTypes().setAll(botonUno, botonDos, ButtonType.APPLY);

            Optional<ButtonType> boton = dialgoPregunta.showAndWait();
            if (boton.get() == ButtonType.OK) {
                System.out.println("Pulsado ok");
            } else if (boton.get() == ButtonType.CANCEL) {
                System.out.println("Pulsado cancelar");
            } else if (boton.get() == botonUno) {
                System.out.println("Pulsado boton uno");
            } else if (boton.get() == ButtonType.APPLY) {
                System.out.println("Pulsado aplicar");
            }

        } else if (actionEvent.getSource() == menuSeleccion) {
            // elemento seleccionado, lista
            ObservableList<Pelicula> listaOpcionesObservable
                    = FXCollections.observableArrayList();
            //listaOpcionesObservable.addAll("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4");
            listaOpcionesObservable.addAll(new Pelicula("Titulo 1", "Genero 1", 1233)
                    , new Pelicula("Titulo 1", "Genero 1", 1233));
            ChoiceDialog<Pelicula> dialogChoice = new ChoiceDialog<>(listaOpcionesObservable.get(0)
                    , listaOpcionesObservable);
            Optional<Pelicula> respuesta = dialogChoice.showAndWait();

            if (respuesta.isPresent()) {
                System.out.println(respuesta.get().getGenero());
            } else {
                Alert alertaWarning = new Alert(Alert.AlertType.WARNING);
                alertaWarning.setHeaderText("Por favor introduce seleccion");
                alertaWarning.show();
            }
        } else if (actionEvent.getSource() == menuTexto) {
            TextInputDialog dialogoTexto = new TextInputDialog("Por favor introduce dato");
            Optional<String> respuesta = dialogoTexto.showAndWait();
            if (respuesta.isPresent()){
                if (!respuesta.get().isEmpty()){
                    System.out.println(respuesta.get());
                } else {
                    System.out.println("Introducidos datos vacios");
                }
            } else {
                System.out.println("Np hay datos");
            }

        }

    }
}