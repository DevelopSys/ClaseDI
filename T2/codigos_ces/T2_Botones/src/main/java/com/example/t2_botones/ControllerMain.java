package com.example.t2_botones;

import com.example.t2_botones.model.MetodoPago;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable, EventHandler<ActionEvent>, ChangeListener<Toggle> {
    @FXML
    private Button botonGeneral;

    @FXML
    private Button botonImagen;

    @FXML
    private Button botonNormal;

    @FXML
    private Button botonURL, botonComprobar;

    @FXML
    private Tab botonesCompuestos;

    @FXML
    private Tab botonesNormales;


    @FXML
    private CheckBox check1;

    @FXML
    private CheckBox check2;

    @FXML
    private CheckBox check3;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private ToggleButton toggle1;

    @FXML
    private ToggleButton toggle2;

    @FXML
    private ToggleButton toggle3;

    private ToggleGroup grupoToggle, grupoRadios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        configurarGrupoToggle();
        personalizarBotones();
        acciones();

    }

    private void configurarGrupoToggle() {
        grupoToggle.getToggles().addAll(toggle2, toggle3);
        radio1.setUserData(new MetodoPago(1,"Pago con tarjeta","Aceptadas: Visa, Mastercard, TipoTarjeta" ));
        radio2.setUserData(new MetodoPago(2,"PayPal","Login necesario en la plataforma" ));
        radio3.setUserData(new MetodoPago(3,"Transferencia","Banco aceptado BBVA" ));
        grupoRadios.getToggles().addAll(radio1, radio2, radio3);
    }

    private void instancias() {
        grupoToggle = new ToggleGroup();
        grupoRadios = new ToggleGroup();
    }

    private void personalizarBotones() {


        String[] urlToggle = new String[]{"https://upload.wikimedia.org/wikipedia/commons/b/bc/On_button.png",
                "https://upload.wikimedia.org/wikipedia/commons/2/23/Off_button.png"};
        toggle1.setBackground(null);
        toggle1.setBorder(null);
        toggle1.setText("");
        ImageView imageToggle = new ImageView();
        toggle1.setGraphic(imageToggle);
        imageToggle.imageProperty()
                .bind(Bindings.when(toggle1.selectedProperty())
                        .then(new Image(urlToggle[0]))
                        .otherwise(new Image(urlToggle[1])));


        botonImagen.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("button.png"))));
        botonImagen.setBackground(null);
        botonImagen.setBorder(null);

        botonURL.setGraphic(new ImageView(new Image("https://www.shutterstock.com/image-vector/golden-close-button-game-interface-260nw-2178668753.jpg")));
        botonURL.setBackground(null);
        botonURL.setBorder(null);
    }

    private void acciones() {

        grupoRadios.selectedToggleProperty().addListener(this);
        grupoToggle.selectedToggleProperty().addListener(this);
        toggle1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean old, Boolean newValue) {
                if (newValue) {
                    System.out.println("Elemento seleccionado");
                    //toggle1.setGraphic(new ImageView(new Image("https://upload.wikimedia.org/wikipedia/commons/b/bc/On_button.png")));
                } else {
                    System.out.println("Elemento deseleccionado");
                    //toggle1.setGraphic(new ImageView(new Image("https://upload.wikimedia.org/wikipedia/commons/2/23/Off_button.png")));

                }
            }
        });
        botonNormal.setOnAction(this);
        botonImagen.setOnAction(this);
        botonURL.setOnAction(this);
        botonGeneral.setOnAction(this);
        botonComprobar.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonComprobar) {
            toggle1.setSelected(true);
            grupoRadios.selectToggle(null);
            if (grupoToggle.getSelectedToggle() != null) {

                System.out.println(((ToggleButton) grupoToggle.getSelectedToggle()).getText());
            } else {
                System.out.println("No hay seleccion en el grupo");
            }
        } else if (actionEvent.getSource() == botonNormal) {

        } else if (actionEvent.getSource() == botonImagen) {

        } else if (actionEvent.getSource() == botonURL) {

        } else if (actionEvent.getSource() == botonGeneral) {

        }
    }

    @Override
    public void changed(ObservableValue<? extends Toggle> observableValue,
                        Toggle toggle, Toggle t1) {
        if (t1 instanceof RadioButton) {
            //System.out.println("Grupo cambiado radios");
            //System.out.println(((MetodoPago)t1.getUserData()).getId());
            switch (((MetodoPago)t1.getUserData()).getId()){
                case 1:
                    // acciones para el tipo de paga1
                    break;
                case 2:
                    // acciones para el tipo de paga2
                    break;
            }
        } else if (t1 instanceof ToggleButton) {
            System.out.println("Grupo cambiado toggle");
        }
    }
}