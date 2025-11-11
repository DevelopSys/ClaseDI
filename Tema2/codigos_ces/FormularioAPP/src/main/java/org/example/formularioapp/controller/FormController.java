package org.example.formularioapp.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.formularioapp.HelloApplication;
import org.example.formularioapp.dao.UsuarioDAOImp;
import org.example.formularioapp.model.Usuario;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FormController implements Initializable {

    @FXML
    private MenuItem menuEliminar, menuDetalle, menuLista;

    @FXML
    private Button botonDetalle;
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
    private ListView<Usuario> listViewUsuarios;

    @FXML
    private GridPane parteDerecha;

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
    private ObservableList<Usuario> listaUsuarios;

    private UsuarioDAOImp usuarioDAOImp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        botonDetalle.setOnAction(new ManejoActions());
        botonAgregar.setOnAction(new ManejoActions());
        botonEliminar.setOnAction(new ManejoActions());
        menuDetalle.setOnAction(new ManejoActions());
        menuEliminar.setOnAction(new ManejoActions());
        menuLista.setOnAction(new ManejoActions());
        checkDisponibilidad.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {
                botonAgregar.setDisable(!newValue);

            }
        });
        toggleLista.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean aBoolean, Boolean t1) {
                if (t1) {
                    panelGeneral.setRight(parteDerecha);
                } else {
                    panelGeneral.setRight(null);
                }
            }
        });
    }

    private void instancias() {
        usuarioDAOImp = new UsuarioDAOImp();
        grupoGenero = new ToggleGroup();
        listaEdades = FXCollections.observableArrayList();
        listaUsuarios =
                FXCollections.observableArrayList(usuarioDAOImp.obtenerUsuarios());
    }

    private void initGUI() {
        grupoGenero.getToggles().addAll(radioMasculino, radioFemenino);
        for (int i = 18; i < 91; i++) {
            listaEdades.add(i);
        }
        listViewUsuarios.setItems(listaUsuarios);
        comboEdad.setItems(listaEdades);
        botonAgregar.setDisable(!checkDisponibilidad.isSelected());
        if (toggleLista.isSelected()) {
            panelGeneral.setRight(parteDerecha);
        } else {
            panelGeneral.setRight(null);
        }
    }

    private void limpiarDatos() {
        texfieldNombre.clear();
        textfieldCorreo.clear();
        textfieldLocalizacion.clear();
        checkDisponibilidad.setSelected(false);
        grupoGenero.selectToggle(null);
        comboEdad.getSelectionModel().select(-1);
    }

    private Usuario estaUsuario(String correo) {

        for (Usuario item : listaUsuarios) {
            if (item.getCorreo().equalsIgnoreCase(correo)) {
                return item;
            }
        }

        return null;
    }

    public void actualizarUsuario(Usuario u) {
        // actualizar el usuario
        System.out.println("Contestacion realizada con exito");

    }

    class ManejoActions implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAgregar) {
                if (!texfieldNombre.getText().isEmpty()
                        && !textfieldCorreo.getText().isEmpty()
                        && !textfieldLocalizacion.getText().isEmpty()
                        && grupoGenero.getSelectedToggle() != null
                        && comboEdad.getSelectionModel().getSelectedItem() >= 0
                ) {
                    String nombre = texfieldNombre.getText();
                    String correo = textfieldCorreo.getText();
                    String localizacion = textfieldLocalizacion.getText();
                    String genero = ((RadioButton) grupoGenero.getSelectedToggle()).getText();
                    boolean disponibilidad = checkDisponibilidad.isSelected();
                    int edad = comboEdad.getSelectionModel().getSelectedItem();
                    Usuario usuario = new Usuario(
                            nombre, correo, localizacion, genero, edad, disponibilidad
                    );
                    boolean fallo = false;
                    try {
                        usuarioDAOImp.insertarUsuario(usuario);
                        listaUsuarios.add(usuario);
                    } catch (SQLException e) {
                        fallo = true;
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error en insercion");
                        alert.setContentText("Mail duplicado, por favor introduce uno nuevo");
                        alert.show();
                    }
                    if (!fallo){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Insercion correcta");
                        alert.setContentText("Usuario insertado correctamente");
                        alert.show();
                        limpiarDatos();
                    }

                    /*
                    if (estaUsuario(correo) != null) {

                        System.out.println("El usuario ya esta en la lista");
                    } else {

                        listaUsuarios.add(usuario);
                        System.out.println("Usuario agregado correctamente");
                        limpiarDatos();
                    }

                     */
                }

                // limpiar todos los datso
            }
            else if (actionEvent.getSource() == botonDetalle || actionEvent.getSource() == menuDetalle ) {
                int posicionSeleccionada = listViewUsuarios.getSelectionModel().getSelectedIndex();
                if (posicionSeleccionada != -1) {
                    Usuario usuario = listViewUsuarios.getSelectionModel().getSelectedItem();
                    Stage ventanaDetalle = new Stage();
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("detalle-view.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                        DialogoController dialogoController = loader.getController();
                        dialogoController.setUsuario(usuario);
                        dialogoController.setFormController(FormController.this);
                        Scene scene = new Scene(root);
                        ventanaDetalle.setScene(scene);
                        ventanaDetalle.initModality(Modality.APPLICATION_MODAL);
                        ventanaDetalle.setTitle("Ventana detalle");
                        ventanaDetalle.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                /*Usuario usuarioSeleccionado = listViewUsuarios.getSelectionModel().getSelectedItem();
                System.out.println("La posicion seleccionada es " + posicionSeleccionada);
                System.out.println("El elemento seleccionado es " + usuarioSeleccionado.getCorreo());

                 */
            } else if (actionEvent.getSource() == botonEliminar || actionEvent.getSource() == menuEliminar) {
                if (listViewUsuarios.getSelectionModel().getSelectedIndex() != -1) {
                    listaUsuarios.remove(listViewUsuarios.getSelectionModel().getSelectedIndex());
                } else {
                    System.out.println("No hay nada seleccionado");
                    Stage ventanaDialogo = new Stage();
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dialogo-view.fxml"));
                        Scene scene = new Scene(loader.load());
                        ventanaDialogo.setScene(scene);
                        ventanaDialogo.setTitle("Confirmacion");
                        ventanaDialogo.setResizable(false);
                        ventanaDialogo.initModality(Modality.APPLICATION_MODAL);
                        ventanaDialogo.showAndWait();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
            else if (actionEvent.getSource() == menuLista){
                toggleLista.setSelected(!toggleLista.isSelected());
            }
        }
    }
}

