package com.example.tablas_ret;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {



    @FXML
    private Button botonAniadir;

    @FXML
    private Button botonDetalles;

    @FXML
    private Button botonEliminar;

    @FXML
    private TableColumn<?, ?> columnaApellido;

    @FXML
    private TableColumn<?, ?> columnaCorreo;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaTelefono;

    @FXML
    private TableView<?> tabla;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();


    }

    private void acciones() {
    }

    private void asociarDatos() {
    }

    private void instancias() {

    }
}
