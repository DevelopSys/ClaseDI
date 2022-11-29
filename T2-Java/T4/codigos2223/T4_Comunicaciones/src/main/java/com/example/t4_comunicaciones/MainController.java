package com.example.t4_comunicaciones;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private MenuItem menuBidireccional;

    @FXML
    private MenuItem menuCerrar;

    @FXML
    private MenuItem menuEscena;

    @FXML
    private RadioMenuItem menuRadio1;

    @FXML
    private RadioMenuItem menuRadio2;

    @FXML
    private RadioMenuItem menuRadio3;

    @FXML
    private MenuItem menuUnidireccional;

    private ToggleGroup grupoOpciones;

    @FXML
    private TextField textFieldScene1;

    @FXML
    private Button botonScene;

    @FXML
    private Button botonStage;

    @FXML
    private Label labelScene1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        initGUI();
        acciones();

    }

    private void initGUI() {
        menuCerrar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("exit.png"))));
        grupoOpciones.getToggles().addAll(menuRadio1, menuRadio2, menuRadio3);
    }

    private void instancias() {
        grupoOpciones = new ToggleGroup();
    }

    private void acciones() {

        menuEscena.setOnAction(new ManejoPulsaciones());
        botonScene.setOnAction(new ManejoPulsaciones());
        grupoOpciones.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                                Toggle toggle, Toggle t1) {
                System.out.println(((RadioMenuItem) t1).getText());
            }
        });
        menuCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonScene
                    || actionEvent.getSource() == menuEscena){

                // Cargar el fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("scene-view.fxml"));
                try {
                    Parent root = loader.load();
                    // Crear scene
                    Scene scene = new Scene(root,botonScene.getScene().getWidth(),botonScene.getScene().getHeight());
                    // En el stage poner la scene
                    Stage stage = (Stage) botonScene.getScene().getWindow();
                    stage.setScene(scene);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
