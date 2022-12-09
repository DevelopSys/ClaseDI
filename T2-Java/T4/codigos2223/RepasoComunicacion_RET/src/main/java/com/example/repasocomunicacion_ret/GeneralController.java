package com.example.repasocomunicacion_ret;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GeneralController implements Initializable {

    @FXML
    private Button botonCorreo;

    @FXML
    private Button botonDNI;

    @FXML
    private Button botonNombre;

    @FXML
    private Button botonTelefono;

    @FXML
    private TableColumn<?, ?> colCorreo;

    @FXML
    private TableColumn<?, ?> colDNI;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML private TableView<Usuario> tabla;

    private ObservableList<Usuario> listaUsuarios;

    @FXML
    private Label labelCorreo;

    @FXML
    private Label labelDNI;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelTelefono;

    @FXML
    private MenuItem menuAdd;

    @FXML
    private MenuItem menuAyuda;

    @FXML
    private MenuItem menuDNI;

    @FXML
    private MenuItem menuRemove;

    @FXML
    private MenuItem menuReset;

    @FXML
    private MenuItem menuSalir;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        configurarTabla();
        acciones();
    }

    private void configurarTabla() {
        tabla.setItems(listaUsuarios);
        //listaUsuarios.add(new Usuario(1,"asdads","asad","awdasd",123));
        colID.setCellValueFactory(new PropertyValueFactory("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDNI.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
    }

    private void acciones() {
        menuSalir.setOnAction(new ManejoPulsaciones());
        botonNombre.setOnAction(new ManejoPulsaciones());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
                if (actionEvent.getSource() == menuSalir){
                    System.exit(0);
                }
                else if (actionEvent.getSource() == botonNombre){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("nombre.fxml"));
                    try {
                        Parent root = loader.load();
                        Stage ventana = new Stage();
                        Scene scene = new Scene(root,400,400);
                        NombreController nombreController = loader.getController();
                        nombreController.setController(GeneralController.this);
                        ventana.setScene(scene);
                        ventana.show();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        }


    }
    public void setNombre(String nombre){
        this.labelNombre.setText(nombre);
    }
}
