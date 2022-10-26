package com.example.penstanias_ret;

import com.example.penstanias_ret.model.CambioBase;
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
import javafx.scene.input.MouseEvent;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonNormal, botonNormalDos, botonCalcular;

    @FXML
    private ToggleButton toggle;

    @FXML private RadioButton radioUno, radioDos, radioTres;

    @FXML private TextField textoOperar;

    private ToggleGroup grupoRadios;

    private DropShadow sombreExterior;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        personalizarBotones();
        asociarDatos();
        acciones();

    }

    private void asociarDatos() {
        radioUno.setUserData(new CambioBase(0,2));
        radioDos.setUserData(new CambioBase(0,8));
        radioTres.setUserData(new CambioBase(0,16));
    }

    private void personalizarBotones() {
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);
        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);
        toggle.setBackground(null);
        if (toggle.isSelected()){
            toggle.setGraphic(new ImageView(new Image(getClass()
                    .getResourceAsStream("switchoff.png"))));
        }else {
            toggle.setGraphic(new ImageView(new Image(getClass()
                    .getResourceAsStream("switchon.png"))));
        }
    }

    private void acciones() {
        // acciones
        // directa setOnEvento setOnAction --> EventHander<ActionEvent>

        botonCalcular.setOnAction(new ManejoPulsaciones());
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        toggle.setOnAction(new ManejoPulsaciones());
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                                Toggle toggle, Toggle t1) {
                RadioButton radioSeleccionado = (RadioButton) t1;
                System.out.println(radioSeleccionado.getText());
            }
        });
        toggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {
                botonNormal.setDisable(toggle.isSelected());
                botonNormalDos.setDisable(toggle.isSelected());

                if (newValue){
                    toggle.setGraphic(new ImageView(new Image(getClass()
                            .getResourceAsStream("switchoff.png"))));
                }else {
                    toggle.setGraphic(new ImageView(new Image(getClass()
                            .getResourceAsStream("switchon.png"))));
                }

            }
        });
        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());


    }

    private void instancias() {
        sombreExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioUno,radioDos,radioTres);

    }


    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            //System.out.println("Evento raton generado");
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                ((Button) mouseEvent.getSource()).setEffect(sombreExterior);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) mouseEvent.getSource()).setEffect(null);
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource() == toggle) {
                botonNormal.setDisable(toggle.isSelected());
                botonNormalDos.setDisable(toggle.isSelected());
            } else if (actionEvent.getSource() == botonNormal) {
                toggle.setSelected(true);
            } else if (actionEvent.getSource() == botonNormalDos) {
                toggle.setSelected(false);
            } else if (actionEvent.getSource() == botonCalcular){
                // comprobar que hay radio y hay cosas en el texto
                RadioButton radioSeleccionado = (RadioButton) grupoRadios.getSelectedToggle();
                CambioBase cambioBase = (CambioBase) radioSeleccionado.getUserData();
                cambioBase.setNumeroDecimal(Integer.valueOf(textoOperar.getText()));
                // realizo el cambio de base
                cambioBase.operacionCambioBase();
                System.out.println(cambioBase.getNumeroConv());
                // base = 2 numeroCambio = 10000101 numeroDecimal = 59
                // base = 8 numeroCambio numeroDecimal = 0
                // base = 16 numeroCambio numeroDecimal = 0

                System.out.println("operandos: "+textoOperar.getText());
                System.out.println("Objeto seleccionado de base "+cambioBase.getBase());

            }

        }

    }
}
