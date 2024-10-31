package org.example.compras;

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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCarrito;

    @FXML
    private Button btnCompra;

    @FXML
    private TextArea editCarrito;

    @FXML
    private TextField editCategoria;

    @FXML
    private TextField editPrecio;

    @FXML
    private TextField editProducto;

    @FXML
    private TextField editRecurrencia;

    @FXML
    private BorderPane panelCarrito, panelGeneral;

    @FXML
    private RadioButton radioMes;

    @FXML
    private RadioButton radioPuntual;

    @FXML
    private Label txtPrecio;

    private ToggleGroup grupo;
    private DropShadow sombra;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        btnAdd.setOnAction(this::handle);
        btnCarrito.setOnAction(this::handle);
        btnCompra.setOnAction(this::handle);
        btnCompra.setOnMouseEntered(new ManejoRaton());
        btnCarrito.setOnMouseEntered(new ManejoRaton());
        btnAdd.setOnMouseEntered(new ManejoRaton());
        btnCompra.setOnMouseExited(new ManejoRaton());
        btnAdd.setOnMouseExited(new ManejoRaton());
        btnCarrito.setOnMouseExited(new ManejoRaton());
        grupo.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (t1==radioMes){
                    editRecurrencia.setDisable(false);
                } else{
                    editRecurrencia.setDisable(true);
                }
            }
        });
    }

    private void instancias() {
        sombra = new DropShadow();
        grupo = new ToggleGroup();
    }

    private void initGUI() {
        panelGeneral.setRight(null);
        btnAdd.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("anadir.png"))));
        btnAdd.setBackground(null);
        btnCarrito.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("buscar.png"))));
        btnCarrito.setBackground(null);
        btnCompra.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("pagar.png"))));
        btnCompra.setBackground(null);
        grupo.getToggles().addAll(radioPuntual,radioMes);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnAdd){
            if ( !editProducto.getText().isEmpty() &&
                    !editCategoria.getText().isEmpty() &&
                    !editPrecio.getText().isEmpty() &&
                    grupo.getSelectedToggle() != null){

                editCarrito.appendText(editProducto.getText()+" - "+editPrecio.getText()+"\n");
                int precioActual = Integer.parseInt(txtPrecio.getText());
                int precioProducto = Integer.parseInt(editPrecio.getText());
                if (grupo.getSelectedToggle()==radioMes){
                    precioProducto  *= Integer.parseInt(editRecurrencia.getText());
                }
                precioActual +=precioProducto;
                txtPrecio.setText(String.valueOf(precioActual));

                editPrecio.setText("");
                editCategoria.setText("");
                editProducto.setText("");
                editRecurrencia.setText("");
                grupo.selectToggle(null);

            }
        }else if (actionEvent.getSource() == btnCarrito){
            if (panelGeneral.getRight()==null){
                panelGeneral.setRight(panelCarrito);
            } else {
                panelGeneral.setRight(null);
            }
        } else if (actionEvent.getSource() == btnCompra){
            if (!editCarrito.getText().isEmpty()){
                // pasar de pantalla
                Stage actual = (Stage) btnAdd.getScene().getWindow();
                Stage nueva = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("finish-view.fxml"));
                try {
                    Parent parent = loader.load();
                    Scene scene = new Scene(parent,600,400);
                    nueva.setScene(scene);
                    nueva.show();
                    actual.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                ((Button)mouseEvent.getSource()).setEffect(null);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                ((Button)mouseEvent.getSource()).setEffect(sombra);
            }
        }
    }
}
