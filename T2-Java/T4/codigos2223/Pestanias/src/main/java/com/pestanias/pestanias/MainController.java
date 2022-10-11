package com.pestanias.pestanias;


import com.pestanias.pestanias.model.TipoPago;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.glyphfont.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // elementos gráficos
    @FXML
    private TabPane panelPestanias;
    @FXML
    private Button botonNormal, botonNormalDos;
    @FXML
    private ToggleButton botonToggle;
    @FXML
    private RadioButton radio1, radio2, radio3;

    @FXML
    private Label labelNombre, labelDesc, labelComision;

    private DropShadow sombraExterior;
    private ToggleGroup grupoRadios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // se ejecuca cuando se asocia la parte grafica y la logica --> setContentView


        instancias();
        asociarDatos();
        configurarBotones();
        acciones();


    }

    private void asociarDatos() {

        radio1.setUserData(new TipoPago("Tarjeta","PAgo con trajeta bancaria",0));
        radio2.setUserData(new TipoPago("Transferencia","PAgo con transferecia bacanria",10));
        radio3.setUserData(new TipoPago("PayPal","PAgo con aplicacion paypal",20));
    }

    private void configurarBotones() {
        // ImageView --> Image
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);

        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);

        botonToggle.setBackground(null);
        if (botonToggle.isSelected()){
            botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
        } else {
            botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
        }

    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1,radio2,radio3);
    }

    private void acciones() {
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        // radio1.setOnAction(new ManejoPulsaciones());
        // botonToggle.setOnAction(new ManejoPulsaciones());
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                RadioButton radioButton = (RadioButton) newValue;
                TipoPago tipoPago = (TipoPago) radioButton.getUserData();
                labelNombre.setText(tipoPago.getNombre());
                labelDesc.setText(tipoPago.getDescripcion());
                labelComision.setText(String.valueOf(tipoPago.getComision()));
            }
        });


        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());
        botonToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {
                botonNormal.setDisable(newValue);
                botonNormalDos.setDisable(newValue);
                if (newValue){
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
                }else {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
                }
            }
        });

        //botonNormal.addEventHandler(MouseEvent.MOUSE_RELEASED, new ManejoRaton());
    }

    class ManejoRaton implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(sombraExterior);
                } else if (mouseEvent.getSource() == botonNormalDos){
                    botonNormalDos.setEffect(sombraExterior);
                }
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                if (mouseEvent.getSource() == botonNormal){
                    botonNormal.setEffect(null);
                } else if (mouseEvent.getSource() == botonNormalDos){
                    botonNormalDos.setEffect(null);
                }
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
                //System.out.println("Raton pressed");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
                System.out.println("Raton clicked");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED){
                System.out.println("Raton released");
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            //System.out.println("Boton pulsado");
            if (actionEvent.getSource() == botonNormal){
                botonToggle.setSelected(true);
            }
            else if(actionEvent.getSource() == botonNormalDos){
                RadioButton radioSeleccionado  = (RadioButton) grupoRadios.getSelectedToggle();
                TipoPago tipoPago = (TipoPago) radioSeleccionado.getUserData();
                System.out.println(tipoPago.getComision());
                System.out.println(tipoPago.getNombre());
                System.out.println(tipoPago.getDescripcion());
            }
        }
    }
}

/*
* 1- CAMBIAR LA IMAGEN DEL TOGGLE PARA QUE PONGA EL ON Y EL OFF
* 2- AL CAMBIAR LA SELECCIÓN DEL TOGGLE GROUP APARECE LA INFORMACION EN 3 LABEL
* 3- AL PULSAR EL BOTON DE OFF APARECE POR CONSOLA LA INFORMACION DEL
* TOGGLE SELECCIONADO
* */
