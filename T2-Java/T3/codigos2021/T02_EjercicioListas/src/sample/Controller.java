package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button botonAgregar, botonLimpiar;

    @FXML
    RadioButton radioLista, radioCombo, radioChoice, radioTodas;

    @FXML
    ComboBox comboEstado, combo;

    @FXML
    ListView listView;

    @FXML
    ChoiceBox choice;

    @FXML
    TextField textNombre, textApellido, textTelefono;

    @FXML
    Label labelSeleccion;

    @FXML
    CheckBox checkDispo;

    ToggleGroup grupoRadios;

    ObservableList listaEstado, listaCombo, listaChoice, listaListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarGrupo();
        personalizarListas();
        acciones();
    }

    private void personalizarListas() {
        comboEstado.setItems(listaEstado);
        listView.setItems(listaListView);
        combo.setItems(listaCombo);
        choice.setItems(listaChoice);
        listaEstado.addAll("Soltero", "Casado", "Divorciado");
    }

    private void acciones() {
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (botonAgregar.isDisable()) {
                    habilitarElementos();
                }
            }
        });
        botonAgregar.setOnAction(new ManejoPulsaciones());
        botonLimpiar.setOnAction(new ManejoPulsaciones());
    }

    private void habilitarElementos() {
        botonAgregar.setDisable(false);
        botonLimpiar.setDisable(false);
        textApellido.setDisable(false);
        textNombre.setDisable(false);
        textTelefono.setDisable(false);
        comboEstado.setDisable(false);
        checkDispo.setDisable(false);
    }

    private void personalizarGrupo() {
        grupoRadios.getToggles().addAll(radioChoice, radioCombo, radioLista, radioTodas);
    }

    private void instancias() {

        grupoRadios = new ToggleGroup();
        listaEstado = FXCollections.observableArrayList();
        listaCombo = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
        listaListView = FXCollections.observableArrayList();

    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAgregar) {
                /*String nombre = textNombre.getText();
                String apellido = textApellido.getText();
                int telefono = Integer.parseInt(textTelefono.getText());
                String estado = comboEstado.getSelectionModel().getSelectedItem().toString();
                Boolean disponibilidad = checkDispo.isSelected();
                Persona p = new Persona(nombre, apellido, estado, telefono, disponibilidad);*/
                String seleccion = ((RadioButton) grupoRadios.getSelectedToggle()).getText();
                switch (seleccion) {
                    case "Todas":
                        System.out.println("todas seleccionadas");
                        break;
                    case "Combo":
                        break;
                    case "Lista":
                        break;
                    case "Choice":
                        break;
                }
            }
        }
    }
}
