package com.example.examencompras;

import com.example.examencompras.model.Producto;
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

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button botonCompra;

    @FXML
    private TextField editNombre;

    @FXML
    private TextField editPrecio;

    @FXML
    private MenuItem menuActivar;

    @FXML
    private MenuItem menuCarrito;

    @FXML
    private MenuItem menuDesactivar;

    @FXML
    private GridPane parteCentral;

    @FXML
    private RadioButton radioRecurrente;

    @FXML
    private RadioButton radioSimple;

    @FXML
    private TextArea textCarrito;

    @FXML private BorderPane root;

    private ToggleGroup grupoCompra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        personalizarBotones();
        acciones();
    }

    private void acciones() {
        menuCarrito.setOnAction(this);
        menuActivar.setOnAction(this);
        menuDesactivar.setOnAction(this);
        botonCompra.setOnAction(this);
    }

    private void instancias() {
        grupoCompra = new ToggleGroup();
        grupoCompra.getToggles().addAll(radioRecurrente,radioSimple);
        radioRecurrente.setUserData("Recurrente");
        radioSimple.setUserData("Simple");
    }

    private void personalizarBotones() {
        botonCompra.setBackground(null);
        botonCompra.setBorder(null);
        botonCompra.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("add.png"))));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == menuCarrito){
            if (root.getRight()!=null){
                root.setRight(null);
            } else {
                root.setRight(textCarrito);
            }
        }
        else if (actionEvent.getSource() == menuActivar) {
            textCarrito.setDisable(false);
            parteCentral.setDisable(false);
        }else if (actionEvent.getSource() == menuDesactivar) {
            textCarrito.setDisable(true);
            parteCentral.setDisable(true);
        } else if (actionEvent.getSource() == botonCompra) {
            if (editNombre.getText().isEmpty() || editPrecio.getText().isEmpty()
            || grupoCompra.getSelectedToggle() == null){
                Alert dialogo = new Alert(Alert.AlertType.WARNING);
                dialogo.setTitle("Aviso");
                dialogo.setHeaderText("Faltan datos");
                dialogo.show();
            } else {
                String nombre = editNombre.getText();
                int precio = Integer.parseInt(editPrecio.getText());
                //String tipo = ((RadioButton)grupoCompra.getSelectedToggle()).getText();
                String tipo = (String) grupoCompra.getSelectedToggle().getUserData();
                textCarrito.appendText(new Producto(nombre,tipo,precio).toString());
                textCarrito.appendText("\n");
                editPrecio.setText("");
                editNombre.setText("");
                grupoCompra.selectToggle(null);
            }
        }
    }
}