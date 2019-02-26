package controladora;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.Usuario;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ControladoraTabla implements Initializable {

    @FXML
    TableView<Usuario> tabla;

    @FXML
    TableColumn cNombre, cApellido, cCorreo;

    ObservableList<Usuario> listaTabla;

    FilteredList<Usuario> listaFiltrada;

    @FXML
    Button bAgregar, bBorrar, btnBuscar;

    @FXML
    TextField eNombre, eApellido, eCorreo, editBuscar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        configurarTabla();
        rellenarTabla();
        acciones();
    }

    private void acciones() {
        bAgregar.setOnAction(new ManejoAcciones());
        bBorrar.setOnAction(new ManejoAcciones());
        btnBuscar.setOnAction(new ManejoAcciones());
    }

    private void configurarTabla() {
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        cCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    }

    private void rellenarTabla() {
        listaTabla.add(new Usuario("Pepe", "Apellido1", "Correo1", 123123));
        listaTabla.add(new Usuario("Carlos", "Apellido1", "Correo1", 123123));
        listaTabla.add(new Usuario("Juan", "Apellido1", "Correo1", 123123));
        listaTabla.add(new Usuario("Luis", "Apellido1", "Correo1", 123123));
        listaTabla.add(new Usuario("Pedro", "Apellido1", "Correo1", 123123));
        listaTabla.add(new Usuario("Alberto", "Apellido1", "Correo1", 123123));
        tabla.setItems(listaFiltrada);
    }

    private void instancias() {
        listaTabla = FXCollections.observableArrayList();
        listaFiltrada = new FilteredList<Usuario>(listaTabla, null);
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (event.getSource() == bAgregar) {
                if (eNombre.getText().isEmpty() || eApellido.getText().isEmpty() || eCorreo.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Faltan datos");
                    alert.show();
                } else if (event.getSource() == bBorrar) {
                    String nombre = eNombre.getText().toString();
                    String apellido = eApellido.getText().toString();
                    String correo = eCorreo.getText().toString();
                    Usuario usuario = new Usuario(nombre, apellido, correo, 123123);
                    listaTabla.add(usuario);
                }
            } else if (event.getSource() == btnBuscar) {
                System.out.println("Pulsado");
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    String ebuscar = null;

                    @Override
                    public boolean test(Usuario usuario) {
                        if (ebuscar == null) {
                            ebuscar = editBuscar.getText().toLowerCase();
                            System.out.println(ebuscar);
                        }
                        return usuario.getNombre().toLowerCase().contains(ebuscar);
                    }
                });
            }

        }
    }
}
