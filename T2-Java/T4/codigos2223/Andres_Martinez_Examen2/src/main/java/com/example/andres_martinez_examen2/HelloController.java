package com.example.andres_martinez_examen2;

import com.example.andres_martinez_examen2.model.Pedido;
import com.example.andres_martinez_examen2.model.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField textoNombre;

    @FXML
    private TextField textoTel;

    @FXML ChoiceBox choicePizzas;

    @FXML ListView<Pizza> listPizzas;

    @FXML ListView<Pedido> listPedidos;

    @FXML
    Button botonAdd;

    @FXML Button botonFinPedido;
    @FXML Button botonDeliver;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }



    private void acciones() {

        botonAdd.setOnAction(new ManejoPulsaciones());
    }

    private void asociarDatos() {
        choicePizzas.setItems(listaChoice);
    }

    private ObservableList<Pizza> listaPizzas;
    private ObservableList<Pedido> listaPedidos;
    private ObservableList<String> listaChoice;

    private void instancias() {

        listaChoice= FXCollections.observableArrayList();
        listaChoice.addAll("Barbacoa", "Hawaina", "Jamón y Queso", "Cuatro Quesos", "Carbonara");


        listaPizzas = FXCollections.observableArrayList();
        listaPizzas.addAll(new Pizza("Barbacoa", 12),
                new Pizza("Hawaina", 10),
                new Pizza("Jamón y Queso", 10),
                new Pizza("Cuatro Quesos", 17),
                new Pizza("Carbonara", 14));
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAdd)
            {

            }
        }
    }
}
