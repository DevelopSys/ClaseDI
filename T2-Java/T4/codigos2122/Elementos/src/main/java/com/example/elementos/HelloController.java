package com.example.elementos;

import com.example.elementos.utils.CuentaCorriente;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ToggleButton btnToggle;

    @FXML
    private RadioButton radioUno, radioDos, radioTres;

    @FXML
    private Button btnComprobar;

    @FXML
    private BorderPane ventanaGeneral;

    @FXML
    private GridPane gridAdicional;

    private ToggleGroup grupoRadios;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarElementos();
        iniciarElementos();
        acciones();
    }

    private void asociarElementos() {
        radioUno.setUserData(new CuentaCorriente("1234A","Paypal","Borja Martin"));
        radioDos.setUserData(new CuentaCorriente("2345A","Internacional","Pedro Martin"));
        radioTres.setUserData(new CuentaCorriente("3456A","Tarjeta","Juan Martin"));
    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioUno,radioDos,radioTres);
    }

    private void iniciarElementos() {
        btnToggle.setSelected(false);
        ventanaGeneral.getChildren().remove(gridAdicional);
        btnToggle.setBackground(null);
        btnToggle.setText("");
        btnToggle.setBorder(null);
        btnToggle.setGraphic(new ImageView(new Image(HelloController.class.getResourceAsStream("power_off.png"))));

    }

    private void acciones() {
        btnComprobar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean activado = btnToggle.isSelected();
                System.out.println(activado);
            }
        });

        btnToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (newValue){
                    ventanaGeneral.setLeft(gridAdicional);
                    btnToggle.setGraphic(new ImageView(new Image(HelloController.class.getResourceAsStream("power_on.png"))));
                } else {
                    ventanaGeneral.getChildren().remove(gridAdicional);
                    btnToggle.setGraphic(new ImageView(new Image(HelloController.class.getResourceAsStream("power_off.png"))));
                }
            }
        });

        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                String titular = ((CuentaCorriente)newValue.getUserData()).getTitular();
                System.out.println(titular);
            }
        });

    }
}