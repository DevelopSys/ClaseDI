package com.example.tablaalumnos;

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

public class HelloController implements Initializable {


    @FXML
    private Button botonAdd;

    @FXML
    private Button botonDetail;

    @FXML
    private Button botonRemove;

    @FXML
    private TableColumn<?, ?> columnaCorreo;

    @FXML
    private TableColumn<?, ?> columnaId;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private MenuItem menuAgregar;

    @FXML
    private MenuItem menuBorrar;

    @FXML
    private MenuItem menuDetalle;

    @FXML
    private TableView<Alumno> tabla;

    private ObservableList<Alumno> listaTabla;

    private int contador = 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        configurarTabla();
        acciones();

    }

    private void acciones() {
        botonRemove.setOnAction(new ManejoPulsaciones());
        botonDetail.setOnAction(new ManejoPulsaciones());
        botonAdd.setOnAction(new ManejoPulsaciones());
        menuDetalle.setOnAction(new ManejoPulsaciones());
        menuBorrar.setOnAction(new ManejoPulsaciones());
        menuAgregar.setOnAction(new ManejoPulsaciones());
    }

    private void configurarTabla() {
        tabla.setItems(listaTabla);
        columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    }

    private void instancias() {
        listaTabla = FXCollections.observableArrayList();
        listaTabla.add(new Alumno(contador,"Alumno1","Apellido1","correo1",1234));
        contador++;
    }

    public void agregarElementos(Alumno alumno){
        alumno.setId(contador);
        listaTabla.add(alumno);
        contador++;
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAdd || actionEvent.getSource() == menuAgregar){
                Stage ventanaAdd = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                        .getResource("add-view.fxml"));
                try {
                    Parent parent = fxmlLoader.load();
                    Scene escenaAdd = new Scene(parent,400,400);
                    ventanaAdd.setScene(escenaAdd);
                    ventanaAdd.show();

                    AddController controller = fxmlLoader.getController();
                    controller.setController(HelloController.this);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }else if (actionEvent.getSource() == botonRemove || actionEvent.getSource() == menuBorrar){

                if (tabla.getSelectionModel().getSelectedIndex()>-1){
                    // borro
                    listaTabla.remove(tabla.getSelectionModel().getSelectedIndex());
                } else {
                    System.out.println("No hay nada seleccionado");
                }

            } else if (actionEvent.getSource() == botonDetail || actionEvent.getSource() == menuDetalle){
                if (tabla.getSelectionModel().getSelectedIndex()>-1){
                    Stage ventanaDetalle = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("detail-view.fxml"));

                    Scene scene = null;
                    try {
                        Parent parent = fxmlLoader.load();
                        scene = new Scene(parent,400,400);
                        DetailController detailController = fxmlLoader.getController();
                        detailController.setearAlumno(tabla.getSelectionModel().getSelectedItem());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ventanaDetalle.setScene(scene);
                    ventanaDetalle.show();
                }else {
                    System.out.println("No hay nada seleccionado");
                }
            }
        }
    }
}