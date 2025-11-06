package org.example.formularioapp.controller;

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
import javafx.scene.layout.GridPane;
import org.example.formularioapp.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private Button buttonDetalle, buttonAgregar, buttonEliminar;

    @FXML
    private CheckBox checkDisponibilidad;

    @FXML
    private ComboBox<Integer> comboEdad;

    @FXML
    private GridPane panelLista;

    @FXML
    BorderPane panelGeneral;

    @FXML
    private RadioButton radioFemenino, radioMasculino;

    @FXML
    private TextField textFieldNombre, textfieldApellido, textfieldCorreo;

    @FXML
    private ToggleButton toggleLista;

    @FXML
    private ListView<Usuario> listViewUsuarios;

    private ToggleGroup grupoGenero;

    private ObservableList<Integer> listaEdades;

    private ObservableList<Usuario> listaUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();

        acciones();
    }

    private void acciones() {
        toggleLista.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean aBoolean, Boolean newValue) {
                if (newValue) {
                    panelGeneral.setRight(panelLista);
                } else {
                    panelGeneral.setRight(null);
                }
            }
        });
        checkDisponibilidad.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean aBoolean, Boolean t1) {
                buttonAgregar.setDisable(!t1);

            }
        });
        buttonAgregar.setOnAction(new ManejoAcciones());
    }

    private void initGUI() {
        buttonAgregar.setDisable(!checkDisponibilidad.isSelected());
        panelGeneral.setRight(null);
        grupoGenero.getToggles().addAll(radioFemenino, radioMasculino);
        comboEdad.setItems(listaEdades);
        listViewUsuarios.setItems(listaUsuarios);
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaEdades = FXCollections.observableArrayList();
        for (int i = 18; i <= 90; i++) {
            listaEdades.add(i); // [18....90]
        }
        grupoGenero = new ToggleGroup();
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == buttonAgregar) {
                Usuario usuario = new Usuario(textFieldNombre.getText(),
                        textfieldApellido.getText(),
                        textfieldCorreo.getText(),
                        ((RadioButton) grupoGenero.getSelectedToggle()).getText(),
                        comboEdad.getSelectionModel().getSelectedItem(),
                        checkDisponibilidad.isSelected()
                );
                listaUsuarios.add(usuario);
            }
        }
    }
}
