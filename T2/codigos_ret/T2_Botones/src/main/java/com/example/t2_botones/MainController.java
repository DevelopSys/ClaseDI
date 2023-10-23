package com.example.t2_botones;

import com.example.t2_botones.model.MetodoPago;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button botonComprobar;

    @FXML
    private CheckBox opcionDos;

    @FXML
    private CheckBox opcionTres;

    @FXML
    private CheckBox opcionUno;

    @FXML
    private RadioButton pagoDos;

    @FXML
    private RadioButton pagoTres;

    @FXML
    private RadioButton pagoUno;

    @FXML
    private ToggleButton toggleActivar;

    @FXML
    private GridPane panelCentral;

    @FXML
    private Button botonDos;

    @FXML
    private Button botonTres;

    @FXML
    private Button botonUno;

    private ToggleGroup grupoPago;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();

        personalizarBotones();

        acciones();
    }

    private void instancias() {
        grupoPago = new ToggleGroup();
        grupoPago.getToggles().addAll(pagoUno, pagoDos, pagoTres);
        // al pulsar en el boton, aparecerá el nombre del pago seleccionado
        // toggleSeleccionado.getText()
    }

    private void acciones() {

        botonComprobar.setOnAction(this);
        grupoPago.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                                Toggle toggle, Toggle t1) {
                System.out.println(((RadioButton) t1).getText());
                System.out.println("La comision asociada al metodo es: " +
                        ((MetodoPago) t1.getUserData()).getComisiones());
            }
        });

        toggleActivar.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                panelCentral.setDisable(!t1);
            }
        });

        for (Node item : panelCentral.getChildren()) {
            if (item instanceof Button) {
                ((Button) item).setOnAction(this);
            }
        }
    }

    private void personalizarBotones() {
        botonComprobar.setBackground(null);
        botonComprobar.setText(null);
        botonComprobar.setBorder(null);
        toggleActivar.setBackground(null);
        toggleActivar.setText(null);
        toggleActivar.setBorder(null);
        botonComprobar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("start.png"))));
        ImageView imageView = new ImageView();
        toggleActivar.setGraphic(imageView);
        imageView.imageProperty().bind(Bindings.when(toggleActivar.selectedProperty())
                .then(new Image(getClass().getResourceAsStream("encender.png")))
                .otherwise(new Image(getClass().getResourceAsStream("apagar.png"))));

        pagoUno.setUserData(new MetodoPago(1, "PayPal", new String[]{"Movil", "Rapidez"}, 3.0));
        pagoDos.setUserData(new MetodoPago(2, "Transferencia", new String[]{"Dinero bancario", "Comodidad"}, 0.5));
        pagoTres.setUserData(new MetodoPago(3, "Efectivo", new String[]{"Dinero", "Rapidez", "Corriente"}, 0));


    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonComprobar) {
            toggleActivar.setSelected(!toggleActivar.isSelected());
            if (grupoPago.getSelectedToggle() != null) {
                System.out.println(((RadioButton) grupoPago.getSelectedToggle()).getText());
            }
                /*if (toggleActivar.isSelected()){
                    toggleActivar.setSelected(false);
                } else {
                    toggleActivar.setSelected(true);
                }*/
        } else {

        System.out.println(((Button) actionEvent.getSource()).getText());
        }

    }
}