package org.example.formularioapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private Button botonAgregar;

    @FXML
    private Button botonEliminar;

    @FXML
    private CheckBox checkDisponibilidad;

    @FXML
    private ComboBox<Integer> comboEdad;

    @FXML
    private BorderPane panelGeneral;

    @FXML
    private FlowPane parteDerecha;

    @FXML
    private RadioButton radioFemenino;

    @FXML
    private RadioButton radioMasculino;

    @FXML
    private TextField texfieldNombre;

    @FXML
    private TextField textfieldCorreo;

    @FXML
    private TextField textfieldLocalizacion;

    @FXML
    private ToggleButton toggleLista;

    private ToggleGroup grupoGenero;

    private ObservableList<Integer> listaEdades;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        botonAgregar.setOnAction(new ManejoActions());
        botonEliminar.setOnAction(new ManejoActions());
        checkDisponibilidad.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {
                    botonAgregar.setDisable(!newValue);

            }
        });
    }

    private void instancias() {
        grupoGenero = new ToggleGroup();
        grupoGenero.getToggles().addAll(radioMasculino, radioFemenino);
        listaEdades = FXCollections.observableArrayList();
        for (int i = 18; i < 91; i++) {
            listaEdades.add(i);
        }
    }

    private void initGUI() {
        comboEdad.setItems(listaEdades);
        botonAgregar.setDisable(!checkDisponibilidad.isSelected());
    }

    class ManejoActions implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAgregar) {

                String nombre = texfieldNombre.getText();
                String correo = textfieldCorreo.getText();
                String localizacion = textfieldLocalizacion.getText();
                String genero = ((RadioButton) grupoGenero.getSelectedToggle()).getText();
                boolean disponibilidad = checkDisponibilidad.isSelected();
                int edad = comboEdad.getSelectionModel().getSelectedItem();

                System.out.println("nombre = " + nombre);
                System.out.println("correo = " + correo);
                System.out.println("localizacion = " + localizacion);
                System.out.println("genero = " + genero);
                System.out.println("disponibilidad = " + disponibilidad);
                System.out.println("edad = " + edad);

            } else if (actionEvent.getSource() == botonEliminar) {

            }
        }
    }
}
