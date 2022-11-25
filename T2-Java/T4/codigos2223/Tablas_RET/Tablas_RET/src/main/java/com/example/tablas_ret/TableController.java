package com.example.tablas_ret;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {


    @FXML
    private TableColumn columnaApellido;

    @FXML
    private TableColumn columnaCorreo;

    @FXML
    private TableColumn columnaNombre;

    @FXML
    private TableColumn columnaTelefono;

    @FXML
    private TableView<Usuario> tabla;
    private ObservableList<Usuario> listaUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        asociarDatos();

    }

    private void asociarDatos() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory("apellido"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        tabla.setItems(listaUsuarios);
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.add(new Usuario("Borja","Martin","Correo@correo.com","1234A",1234,30));
        listaUsuarios.add(new Usuario("Juan","Gomez","Correo@correo.com","1234A",1234,30));
        listaUsuarios.add(new Usuario("Fran","Vera","Correo@correo.com","1234A",1234,30));
        listaUsuarios.add(new Usuario("Kike","Perez","Correo@correo.com","1234A",1234,30));
    }
}
