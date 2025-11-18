package org.example.examenpizzeria.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.examenpizzeria.model.Pedido;
import org.example.examenpizzeria.model.Pizza;

import java.net.URL;
import java.util.ResourceBundle;

public class PizzeriaController implements Initializable {

    @FXML
    private Button botonAgregar;

    @FXML
    private ComboBox<Pizza> comboPizzas;
    private ObservableList<Pizza> listadoPizzas;

    @FXML
    private TextField editNombre;

    @FXML
    private TextField editelefono;

    @FXML
    private ListView<Pedido> listViewPizzas;
    private ObservableList<Pedido> listaPedidos;

    @FXML
    private RadioButton radioFamiliar;

    @FXML
    private RadioButton radioMEdiano;

    @FXML
    private RadioButton rarioPeqenio;
    private ToggleGroup grupoTamanio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();

    }

    private void acciones() {
        botonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!editelefono.getText().isEmpty() && !editNombre.getText().isEmpty()
                        && comboPizzas.getSelectionModel().getSelectedIndex() != -1
                        && grupoTamanio.getSelectedToggle() != null
                ) {

                    String nombre = editNombre.getText();
                    int telefono = Integer.parseInt(editelefono.getText());
                    Pizza pizza = comboPizzas.getSelectionModel().getSelectedItem();
                    pizza.setTamanio(((RadioButton) grupoTamanio.getSelectedToggle()).getText());
                    int precio = 0;


                    switch (pizza.getTamanio()) {
                        case "pequeño" -> {
                            precio = 10;
                        }
                        case "mediano" -> {
                            precio = 15;
                        }
                        case "familiar" -> {
                            precio = 20;
                        }
                    }
                    Pedido.id = Pedido.id + 1;
                    Pedido pedido = new Pedido(nombre, pizza, precio);
                    listaPedidos.add(pedido);
                    limpiarElementos();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setContentText("Faltan datos");
                    alerta.setTitle("Datos");
                    alerta.show();
                }
            }
        });
    }

    private void limpiarElementos() {
        editelefono.clear();
        editNombre.clear();
        comboPizzas.getSelectionModel().select(-1);
        grupoTamanio.selectToggle(null);
    }

    private void initGUI() {
        listadoPizzas.addAll(new Pizza("Barcacoa"), new Pizza("Cuatro quesos"));
        comboPizzas.setItems(listadoPizzas);
        listViewPizzas.setItems(listaPedidos);
        grupoTamanio.getToggles().addAll(rarioPeqenio, radioMEdiano, radioFamiliar);
    }

    private void instancias() {
        grupoTamanio = new ToggleGroup();
        listadoPizzas = FXCollections.observableArrayList();
        listaPedidos = FXCollections.observableArrayList();
    }
}

