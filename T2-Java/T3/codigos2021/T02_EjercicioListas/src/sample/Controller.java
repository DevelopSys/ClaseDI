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
    ComboBox comboEstado;

    @FXML ComboBox<Persona>
    combo;

    @FXML
    ListView<Persona> listView;

    @FXML
    ChoiceBox<Persona> choice;

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

        listView.getSelectionModel().selectedItemProperty().addListener(new ManejoCambios());
        choice.getSelectionModel().selectedItemProperty().addListener(new ManejoCambios());
        combo.getSelectionModel().selectedItemProperty().addListener(new ManejoCambios());


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
                String nombre = textNombre.getText();
                String apellido = textApellido.getText();
                int telefono = Integer.parseInt(textTelefono.getText());
                String estado = comboEstado.getSelectionModel().getSelectedItem().toString();
                Boolean disponibilidad = checkDispo.isSelected();
                Persona persona = new Persona(nombre, apellido, estado, telefono, disponibilidad);
                String seleccion = ((RadioButton) grupoRadios.getSelectedToggle()).getText();
                switch (seleccion) {
                    case "Todas":
                        //System.out.println("todas seleccionadas");
                        listaChoice.addAll(persona);
                        listaCombo.addAll(persona);
                        listaListView.addAll(persona);
                        break;
                    case "Combo":
                        listaCombo.addAll(persona);
                        break;
                    case "Lista":
                        listaListView.addAll(persona);
                        break;
                    case "Choice":
                        listaChoice.addAll(persona);
                        break;
                }
            }
            else if (actionEvent.getSource() == botonLimpiar){
                textNombre.clear();
                textApellido.clear();
                textTelefono.clear();
                checkDispo.setSelected(false);
                comboEstado.getSelectionModel().select(-1);
            }
        }
    }
    class ManejoCambios implements ChangeListener<Persona>{
        @Override
        public void changed(ObservableValue observableValue, Persona o, Persona t1) {
            labelSeleccion.setText(t1.getNombre()+ t1.getApellido()+t1.getEstado()+t1.getTelefono());
        }
    }
}
