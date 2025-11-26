package org.example.examen.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.examen.Launcher;
import org.example.examen.dao.ProductoDAO;
import org.example.examen.dao.UsuarioDAO;
import org.example.examen.model.Producto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListaController implements Initializable {

    @FXML
    private ListView<Producto> listViewProductos;
    @FXML
    private ComboBox<String> comboCategorias;
    @FXML
    private Button btnFiltrar, btnDetalle;

    private ObservableList<Producto> listaProductos;
    private ObservableList<String> listaCategorias;
    private ProductoDAO productoDAO;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instancias();
        initGUI();
        acciones();

    }

    private void acciones() {

        String dato = "ASDASD";
        btnFiltrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String item = comboCategorias.getSelectionModel().getSelectedItem();
                listaProductos = FXCollections.observableArrayList(productoDAO.getProductos(item));
                listViewProductos.refresh();
            }
        });
        btnDetalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Producto producto = listViewProductos.getSelectionModel().getSelectedItem();
                if(producto!=null){
                    //Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    // alert.setContentText(producto.toString());
                    FXMLLoader loader = new FXMLLoader(Launcher.class.getResource("detail-view.fxml"));
                    try {
                        Parent root = loader.load();
                        DetailController detailController = loader.getController();
                        detailController.setProducto(producto);
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
    }

    private void initGUI() {
        if (!productoDAO.getProductos()) {
            productoDAO.insertarProducto();
        }
        listaProductos = FXCollections.observableArrayList(productoDAO.getProductos("Todos"));
        listViewProductos.setItems(listaProductos);
    }

    private void instancias() {
        productoDAO = new ProductoDAO();
        listaCategorias = FXCollections.observableArrayList();
        listaCategorias.addAll("Muebles", "Tecnologia", "Ropa", "Todas");
        comboCategorias.setItems(listaCategorias);
        listaProductos = FXCollections.observableArrayList();
    }
}
