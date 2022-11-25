package com.example.tablas_ret;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class TableController implements Initializable {


    @FXML
    private Button botonAdd, botonRemove, botonDetail;

    @FXML
    private TableColumn columnaApellido;

    @FXML
    private TableColumn columnaCorreo;

    @FXML
    private TableColumn columnaNombre;

    @FXML
    private TableColumn columnaTelefono;

    @FXML private TextField textoFiltrar;
    @FXML
    private TableView<Usuario> tabla;
    private ObservableList<Usuario> listaUsuarios;
    private FilteredList<Usuario> listaFiltrada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        asociarDatos();
        acciones();

    }

    private void acciones() {

        textoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue,
                                String s, String t1) {
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return usuario.getNombre().toLowerCase().contains(t1.toLowerCase());
                    }
                });
            }
        });
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario>
                                        observableValue, Usuario usuario,
                                Usuario t1) {
                System.out.println(t1);
            }
        });
        botonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                listaUsuarios.add(new Usuario("Ejemplo", "Ejemplo", "Ejemplo", "123A", 123, 23));
            }
        });
        botonRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (tabla.getSelectionModel().getSelectedIndex() > -1) {
                    listaUsuarios.remove(tabla.getSelectionModel().getSelectedIndex());
                    tabla.getSelectionModel().clearSelection();
                }
            }
        });

        botonDetail.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (tabla.getSelectionModel().getSelectedIndex() > -1) {
                    System.out.println(tabla.getSelectionModel().getSelectedItem());
                    tabla.getSelectionModel().clearSelection();
                }
            }
        });
    }

    private void asociarDatos() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        tabla.setItems(listaFiltrada);
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.add(new Usuario("Borja", "Martin", "Correo@correo.com", "1234A", 1234, 30));
        listaUsuarios.add(new Usuario("Juan", "Gomez", "Correo@correo.com", "1234A", 1234, 30));
        listaUsuarios.add(new Usuario("Fran", "Vera", "Correo@correo.com", "1234A", 1234, 30));
        listaUsuarios.add(new Usuario("Kike", "Perez", "Correo@correo.com", "1234A", 1234, 30));
        listaFiltrada = new FilteredList(listaUsuarios);
    }
}
