package org.example.usuarios;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.usuarios.dao.ApiDAO;
import org.example.usuarios.dao.UsuarioDAO;
import org.example.usuarios.model.Producto;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerCompra implements Initializable {


    @FXML
    private Button btnComprar;

    @FXML
    private ComboBox<String> comboCategorias;

    @FXML
    private ListView<Producto> listaCompra;

    @FXML
    private ListView<Producto> listaProductos;

    @FXML
    private Label textoProductos;

    private int idUsuario;

    private ApiDAO apiDAO;
    private UsuarioDAO usuarioDAO;
    private ObservableList<Producto>listaCompraObs;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        comboCategorias.setItems(apiDAO.getAllCategories());
        comboCategorias.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                listaProductos.setItems(apiDAO.getAllProducts(newValue));
            }
        });
        btnComprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Producto producto = listaProductos.getSelectionModel().getSelectedItem();
                try {
                    usuarioDAO.comprarProducto(idUsuario,producto.getId());
                    listaCompraObs.add(producto);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void instancias() {
        apiDAO = new ApiDAO();
        usuarioDAO = new UsuarioDAO();
        listaCompraObs = FXCollections.observableArrayList();
        listaCompra.setItems(listaCompraObs);
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
