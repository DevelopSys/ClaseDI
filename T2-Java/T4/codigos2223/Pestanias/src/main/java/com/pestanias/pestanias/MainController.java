package com.pestanias.pestanias;


import com.pestanias.pestanias.model.TipoPago;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
    @FXML
    private TextField textFiledUno, textFiledDos;
    @FXML
    private Button botonSuma, botonResta, botonDiv, botonMulti, botonIgual, botonMostrar, botonOcultar;

    @FXML
    private GridPane gridBotones;
    @FXML
    private VBox panelMostrar;

    @FXML
    private BorderPane panelGeneral;

    private int tipoOperacion =-1;
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

        radio1.setUserData(new TipoPago("Tarjeta", "PAgo con trajeta bancaria", 0));
        radio2.setUserData(new TipoPago("Transferencia", "PAgo con transferecia bacanria", 10));
        radio3.setUserData(new TipoPago("PayPal", "PAgo con aplicacion paypal", 20));
    }

    private void configurarBotones() {
        // ImageView --> Image
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);

        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);

        botonToggle.setBackground(null);
        if (botonToggle.isSelected()) {
            botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
        } else {
            botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
        }

    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1, radio2, radio3);
    }

    private void acciones() {
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        botonMostrar.setOnAction(new ManejoPulsaciones());
        botonOcultar.setOnAction(new ManejoPulsaciones());
        for (Node child : gridBotones.getChildren()) {
            if (child instanceof Button){
                ((Button)child).setOnAction(new ManejoPulsaciones());
            }
        }

        /*botonSuma.setOnAction(new ManejoPulsaciones());
        botonResta.setOnAction(new ManejoPulsaciones());
        botonMulti.setOnAction(new ManejoPulsaciones());
        botonDiv.setOnAction(new ManejoPulsaciones());
        botonIgual.setOnAction(new ManejoPulsaciones());*/

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
                if (newValue) {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
                } else {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
                }
            }
        });
        textFiledUno.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                char letraPulsada = keyEvent.getCharacter().charAt(0);
                System.out.println(Character.isDigit(letraPulsada));
            }
        });

        //botonNormal.addEventHandler(MouseEvent.MOUSE_RELEASED, new ManejoRaton());
    }

    class ManejoRaton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(sombraExterior);
                } else if (mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(sombraExterior);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(null);
                } else if (mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(null);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                //System.out.println("Raton pressed");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                System.out.println("Raton clicked");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                System.out.println("Raton released");
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {



        @Override
        public void handle(ActionEvent actionEvent) {
            //System.out.println("Boton pulsado");
            if (actionEvent.getSource() == botonNormal) {
                botonToggle.setSelected(true);
                System.out.println(textFiledUno.getText());
            }
            else if (actionEvent.getSource() == botonNormalDos) {
                RadioButton radioSeleccionado = (RadioButton) grupoRadios.getSelectedToggle();
                TipoPago tipoPago = (TipoPago) radioSeleccionado.getUserData();
                System.out.println(tipoPago.getComision());
                System.out.println(tipoPago.getNombre());
                System.out.println(tipoPago.getDescripcion());
            }
            else if (actionEvent.getSource() == botonSuma){
                tipoOperacion = 0;
                /*if (Character.isDigit(textFiledUno.getText().charAt(0)) && Character.isDigit(textFiledDos.getText().charAt(0))){
                    int suma = Integer.parseInt(String.valueOf(textFiledUno.getText().charAt(0))) + Integer.parseInt(String.valueOf(textFiledDos.getText().charAt(0)));
                    System.out.println("La suma de los valores es "+suma);
                } else {
                    System.out.println("Alguno de los elementos no es numero");
                }*/

            }
            else if (actionEvent.getSource() == botonResta){
                tipoOperacion = 1;
            }
            else if (actionEvent.getSource() == botonMulti){
                tipoOperacion = 2;
            }
            else if (actionEvent.getSource() == botonDiv){
                tipoOperacion = 3;
            }
            else if (actionEvent.getSource() == botonIgual){
                int op1 = Integer.parseInt(String.valueOf(textFiledUno.getText().charAt(0)));
                int op2 = Integer.parseInt(String.valueOf(textFiledDos.getText().charAt(0)));
                double resultado = 0.0;
                switch (tipoOperacion){
                    case 0:
                        resultado = op1+op2;
                        break;
                    case 1:
                        resultado = op1-op2;
                        break;
                    case 2:
                        resultado = op1*op2;
                        break;
                    case 3:
                        resultado = (double) op1/ op2;
                        break;
                }
                System.out.printf("El resutaldo de la operacion es %.2f",resultado);
            }
            else if (actionEvent.getSource() == botonMostrar){

                //panelMostrar.setVisible(true);
                panelGeneral.setRight(panelMostrar);
            } else if(actionEvent.getSource() == botonOcultar){
                // VBOX --
                //panelMostrar.setVisible(false);
                panelGeneral.getChildren().remove(panelMostrar);
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
