package org.example.formularioapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private Button buttonDetalle, buttonAgregar, buttonEliminar;

    @FXML
    private CheckBox checkDisponibilidad;

    @FXML
    private ComboBox<?> comboEdad;

    @FXML
    private FlowPane panelLista;

    @FXML
    private RadioButton radioFemenino, radioMasculino;

    @FXML
    private TextField textFieldNombre, textfieldApellido, textfieldCorreo;

    @FXML
    private ToggleButton toggleLista;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
