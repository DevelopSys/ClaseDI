package org.example.gestor;

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

public class UserController implements Initializable, EventHandler<ActionEvent> {


    @FXML
    private Button btnAnadir;

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<?, ?> columnaApellido;

    @FXML
    private TableColumn<?, ?> columnaMail;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableView<Usuario> tablaUsuarios;
    @FXML
    private TextField textoFiltrar;

    private FilteredList<Usuario> listaFiltrada;

    private ObservableList<Usuario> listaUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void acciones() {
        btnAnadir.setOnAction(this);
        btnConsultar.setOnAction(this);
        btnEliminar.setOnAction(this);
        textoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return usuario.getNombre().contains(newValue);
                    }
                });

            }
        });
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observable, Usuario oldValue, Usuario newValue) {
                System.out.println("La pass del seleccionado es " + newValue.getPass());
            }
        });
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.addAll(
                new Usuario("Borja", "martin", "correo1@gmail.com", "1", 1),
                new Usuario("Juan", "Marcos", "correo2@gmail.com", "1", 1),
                new Usuario("Jesus", "Lopez", "correo3@gmail.com", "1", 1)
        );
        listaFiltrada = new FilteredList<>(listaUsuarios);
        tablaUsuarios.setItems(listaFiltrada);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaMail.setCellValueFactory(new PropertyValueFactory<>("correo"));


    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == btnAnadir) {
            listaUsuarios.add(new Usuario("NuevoN", "NuevoA", "NuevoC", "123123", 1));
        } else if (event.getSource() == btnConsultar) {

            if (tablaUsuarios.getSelectionModel().getSelectedIndex() != -1) {
                Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
                System.out.println("La pass del seleccionado es " + seleccionado.getPass());
            } else {
                System.out.println("No hay nada seleccionado");
            }

        } else if (event.getSource() == btnEliminar) {
            if (tablaUsuarios.getSelectionModel().getSelectedIndex() != -1) {
                Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
                listaUsuarios.remove(seleccionado);

                //listaUsuarios.remove(tablaUsuarios.getSelectionModel().getSelectedIndex());
            } else {
                System.out.println("No hay nada seleccionado");
            }
        }
    }
}
