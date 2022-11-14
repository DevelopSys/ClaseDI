package com.example.menus;

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
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private MenuItem menuSalir, menuComunicarEspecifico, menuComunicaDefecto, menuEscena;
    @FXML
    private RadioMenuItem menuActivado, menuDesactivado;
    @FXML private GridPane gridCentral;
    private ToggleGroup grupoMenus;
    private ContextMenu menuContextual;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        insancias();
        personalizarBotones();
        acciones();

    }

    private void insancias() {
        grupoMenus = new ToggleGroup();
        grupoMenus.getToggles().setAll(menuActivado, menuDesactivado);
        menuContextual = new ContextMenu();
        menuContextual.getItems().setAll(menuSalir, menuComunicaDefecto, menuComunicarEspecifico, menuEscena, menuActivado, menuDesactivado);
    }
    private void personalizarBotones() {
        menuComunicaDefecto.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("comunicar.png"))));
        menuComunicaDefecto.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        menuComunicarEspecifico.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("comunicar_esp.png"))));
        menuComunicarEspecifico.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
    }
    private void acciones() {
        menuSalir.setOnAction(new ManejoPulsaciones());
        menuComunicarEspecifico.setOnAction(new ManejoPulsaciones());
        menuComunicaDefecto.setOnAction(new ManejoPulsaciones());
        menuEscena.setOnAction(new ManejoPulsaciones());
        grupoMenus.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                                Toggle toggle, Toggle t1) {
                //System.out.println(((RadioMenuItem)t1).getText());
                //System.out.println(t1.getText());
                RadioMenuItem radioSeleccionado = (RadioMenuItem)t1;
                if (radioSeleccionado.getText().equalsIgnoreCase("activado")){
                    menuSalir.setDisable(false);
                } else {
                    menuSalir.setDisable(true);
                }
            }
        });
        gridCentral.setOnMouseClicked(new ManejoRaton());
    }
    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuSalir){
                System.exit(0);
            } else if (actionEvent.getSource() == menuComunicaDefecto){
                System.out.println("Comunicando por defecto......");
                // 1- Tener una ventana
                Stage ventana = new Stage();
                // 2- FXML ---> parte gráfica
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("segunda-pantalla.fxml"));
                try {
                    Parent root = fxmlLoader.load();
                    // 3- Tener una scene
                    Scene escena = new Scene(root,400,400);
                    // 4- Unir scene y stage
                    ventana.setScene(escena);
                    SecondController controller = fxmlLoader.getController();
                    controller.recepcionarTexto("Texto pasar por defecto");
                    // 5- Hacer visible la ventana
                    ventana.setTitle("Ventana secundaria");
                    ventana.show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    class ManejoRaton implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {
            //System.out.println("Evento ratón detectado");
            if (mouseEvent.getButton() == MouseButton.SECONDARY){
                menuContextual.show(gridCentral,mouseEvent.getX(), mouseEvent.getY());
            }

        }
    }
}