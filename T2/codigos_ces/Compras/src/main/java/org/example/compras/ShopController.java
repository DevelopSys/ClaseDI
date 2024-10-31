package org.example.compras;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShopController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    public BorderPane panelGeneral;
    @FXML
    private Button botonAdd;

    @FXML
    private Button botonBuscar;

    @FXML
    private Button botonCompra;

    @FXML
    private TextArea editCarrito;

    @FXML
    private TextField editCategoria;

    @FXML
    private TextField editPrecio;

    @FXML
    private TextField editProducto;

    @FXML
    private TextField editRecurrente;

    @FXML
    private BorderPane panelCarrito;

    @FXML
    private RadioButton radioMes;

    @FXML
    private RadioButton radioPuntual;

    @FXML
    private Label txtPrecio;

    private DropShadow sombra;
    private ToggleGroup grupoCompra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        intancias();
        initGUI();
        acciones();

    }

    private void intancias() {
        sombra = new DropShadow();
        grupoCompra = new ToggleGroup();
    }

    private void acciones() {
        botonBuscar.setOnAction(this);
        botonAdd.setOnAction(this);
        botonCompra.setOnAction(this);
        botonCompra.setOnMouseExited(new ManejoRaton());
        botonBuscar.setOnMouseExited(new ManejoRaton());
        botonAdd.setOnMouseExited(new ManejoRaton());
        botonAdd.setOnMouseEntered(new ManejoRaton());
        botonBuscar.setOnMouseEntered(new ManejoRaton());
        botonCompra.setOnMouseEntered(new ManejoRaton());
        grupoCompra.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (t1 == radioMes){
                    editRecurrente.setDisable(false);
                } else {
                    editRecurrente.setDisable(true);
                }
            }
        });
    }

    private void initGUI() {
        grupoCompra.getToggles().addAll(radioMes,radioPuntual);
        panelGeneral.setRight(null);
        botonBuscar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("buscar.png"))));
        botonBuscar.setBackground(null);
        botonAdd.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("anadir.png"))));
        botonAdd.setBackground(null);
        botonCompra.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("pagar.png"))));
        botonCompra.setBackground(null);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonBuscar) {
            if (panelGeneral.getRight() != null) {
                panelGeneral.setRight(null);
            } else {
                panelGeneral.setRight(panelCarrito);
            }
        } else if (actionEvent.getSource() == botonAdd) {
            // comprar - con los campos rellenos
            if (!editCategoria.getText().isEmpty()
                    && !editPrecio.getText().isEmpty()
                    && !editProducto.getText().isEmpty()
            ) {
                editCarrito.appendText(editProducto.getText() + "-" + editPrecio.getText()+"\n");
                editPrecio.setText("");
                editProducto.setText("");
                editCategoria.setText("");
                editRecurrente.setText("");
                //TODO el grupo y el precio si es recurrente
                grupoCompra.selectToggle(null);

                int precioActual = Integer.parseInt(txtPrecio.getText());
                int precioProducto = Integer.parseInt(editPrecio.getText());
                if (grupoCompra.getSelectedToggle()==radioMes){
                    precioProducto = precioProducto* Integer.parseInt(editRecurrente.getText());
                }

                txtPrecio.setText(String.valueOf(precioActual+precioProducto));
            } else {
                System.out.println("Fallo");
            }
        } else if (actionEvent.getSource() == botonCompra) {
            System.out.println("asdasd");
            if (!editCarrito.getText().isEmpty()){
                Stage actual = (Stage) botonCompra.getScene().getWindow();
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("finish-view.fxml"));
                try {
                    Scene scene = new Scene(loader.load(),500,500);
                    stage.setScene(scene);
                    stage.setTitle("Finalizado");
                    stage.show();
                    actual.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) (mouseEvent.getSource())).setEffect(null);
            } else {
                ((Button) (mouseEvent.getSource())).setEffect(sombra);
            }
        }
    }
}
