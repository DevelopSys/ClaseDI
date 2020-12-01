package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAgregar implements Initializable {

    @FXML
    TextField nombreAgregar, localidadAgregar, telefonoAgregar, productoAgregar;

    @FXML
    Button botonAgregar;

    ControllerMain controllerMain;

    int tipo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        controllerMain = new ControllerMain();


        botonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String nombre = telefonoAgregar.getText();
                String producto = productoAgregar.getText();
                String localidad = localidadAgregar.getText();
                int telefono = Integer.parseInt(telefonoAgregar.getText());
                int numero = 0;
                Pedido p = new Pedido(nombre, localidad, producto, telefono, numero);
                // quier ejecutar agregarProducto(p)
                if (tipo == 1) {
                    controllerMain.agregarProducto(p);
                } else if (tipo == 2){
                    controllerMain.modificarProducto(p);
                }
                botonAgregar.getScene().getWindow().hide();
            }
        });
    }

    public void comunicarPedido(Pedido pedido) {
        telefonoAgregar.setText(String.valueOf(pedido.getTelefono()));
        nombreAgregar.setText(pedido.getNombre());
        localidadAgregar.setText(pedido.getLocalidad());
        productoAgregar.setText(pedido.getProducto());
    }

    public void detallePedido(Pedido pedido) {

        telefonoAgregar.setDisable(true);
        nombreAgregar.setDisable(true);
        localidadAgregar.setDisable(true);
        productoAgregar.setDisable(true);

        telefonoAgregar.setText(String.valueOf(pedido.getTelefono()));
        nombreAgregar.setText(pedido.getNombre());
        localidadAgregar.setText(pedido.getLocalidad());
        productoAgregar.setText(pedido.getProducto());
    }

    public void setControllerMain(ControllerMain controllerMain, int tipo) {
        this.controllerMain = controllerMain;
        this.tipo = tipo;
    }
}
