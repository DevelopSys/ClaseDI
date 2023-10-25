package com.example.examencompras;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextArea arreaCarrito;

    @FXML
    private Button botonAgregar;

    @FXML
    private ToggleButton botonCarrito;

    @FXML
    private GridPane parteCentral;

    @FXML
    private RadioButton radioRecurrente;

    @FXML
    private RadioButton radioSimple;

    @FXML
    private TextField textNombre, textPrecio;

    @FXML
    private BorderPane borderGeneral;

    @FXML
    private ToggleButton toggleActivar;

    private ToggleGroup grupoCompra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        personalizarBotones();
        acciones();

    }

    private void acciones() {
        toggleActivar.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                parteCentral.setDisable(t1);
                arreaCarrito.setDisable(t1);
            }
        });
        botonCarrito.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    borderGeneral.setRight(arreaCarrito);
                } else {
                    borderGeneral.setRight(null);
                }
            }
        });
        botonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (textNombre.getText().isEmpty()
                        || textPrecio.getText().isEmpty()
                        || grupoCompra.getSelectedToggle() == null) {
                    System.out.println("No hay posibilidad de compra");
                } else {
                    boolean compra = false;
                    if (grupoCompra.getSelectedToggle()==radioRecurrente){
                        compra = true;
                    }
                    Producto producto = new Producto(textNombre.getText()
                            , Integer.parseInt(textPrecio.getText()),compra);
                    arreaCarrito.appendText(producto.toString());
                    textPrecio.setText("");
                    textNombre.setText("");
                    grupoCompra.selectToggle(null);
                }
            }
        });


    }

    private void instancias() {
        grupoCompra = new ToggleGroup();
        grupoCompra.getToggles().addAll(radioRecurrente, radioSimple);
    }

    private void personalizarBotones() {
        botonAgregar.setBackground(null);
        botonAgregar.setBorder(null);
        botonAgregar.setText(null);
        botonAgregar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("add.png"))));

        toggleActivar.setBackground(null);
        toggleActivar.setBorder(null);
        toggleActivar.setText(null);
        ImageView imageView = new ImageView();
        toggleActivar.setGraphic(imageView);
        imageView.imageProperty().bind(Bindings.when(toggleActivar.selectedProperty())
                .then(new Image(getClass().getResourceAsStream("apagar.png")))
                .otherwise(new Image(getClass().getResourceAsStream("encender.png"))));
    }
}