package org.example.formularioapp.controller;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.example.formularioapp.FormApplication;
import org.example.formularioapp.model.Usuario;
import org.example.formularioapp.model.UsuarioJSON;
import org.example.formularioapp.model.UsuariosResponse;

import java.io.IOException;
import java.net.MalformedURLException;
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
    private GridPane panelLista, panelJSON;

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

    @FXML
    private ListView<UsuarioJSON> listViewJSON;

    private ToggleGroup grupoGenero;

    private ObservableList<Integer> listaEdades;

    private ObservableList<Usuario> listaUsuarios;
    private ObservableList<UsuarioJSON> listaUsuariosJSON;

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
                    panelGeneral.setLeft(panelJSON);
                } else {
                    panelGeneral.setRight(null);
                    panelGeneral.setLeft(null);
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
        buttonDetalle.setOnAction(new ManejoAcciones());
        buttonEliminar.setOnAction(new ManejoAcciones());
        listViewUsuarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuario, Usuario t1) {
                System.out.println("Usuario anterior - " + usuario);
                System.out.println("Usuario nuevo - " + t1);
            }
        });
    }

    private void initGUI() {
        buttonAgregar.setDisable(!checkDisponibilidad.isSelected());
        panelGeneral.setRight(null);
        panelGeneral.setLeft(null);
        grupoGenero.getToggles().addAll(radioFemenino, radioMasculino);
        comboEdad.setItems(listaEdades);
        listViewUsuarios.setItems(listaUsuarios);
        listViewJSON.setItems(listaUsuariosJSON);


        // 1 Mapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL url = new URL("https://dummyjson.com/users");
            UsuariosResponse response = objectMapper.readValue(url, UsuariosResponse.class);
            listaUsuariosJSON.addAll(response.getUsers());
            /*for (UsuarioJSON item:response.getUsers()) {
                listaUsuariosJSON.add(item);
            }*/
        } catch (MalformedURLException e) {
            System.out.println("La url es invalida");
        } catch (StreamReadException | DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void instancias() {
        listaUsuariosJSON = FXCollections.observableArrayList();
        listaUsuarios = FXCollections.observableArrayList();
        listaEdades = FXCollections.observableArrayList();
        for (int i = 18; i <= 90; i++) {
            listaEdades.add(i); // [18....90]
        }
        grupoGenero = new ToggleGroup();
    }

    private void limpiarCampos() {
        textfieldCorreo.clear();
        textFieldNombre.clear();
        textfieldApellido.clear();
        comboEdad.getSelectionModel().select(-1);
        grupoGenero.selectToggle(null);
        checkDisponibilidad.setSelected(false);
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == buttonAgregar) {

                if (textfieldApellido.getText().isEmpty()
                        || textfieldCorreo.getText().isEmpty()
                        || textFieldNombre.getText().isEmpty()
                        || grupoGenero.getSelectedToggle() == null
                        || comboEdad.getSelectionModel().getSelectedIndex() == -1
                ) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error");
                    alerta.setContentText("Faltan datos por rellenar");
                    alerta.show();
                } else {
                    Usuario usuario = new Usuario(textFieldNombre.getText(),
                            textfieldApellido.getText(),
                            textfieldCorreo.getText(),
                            ((RadioButton) grupoGenero.getSelectedToggle()).getText(),
                            comboEdad.getSelectionModel().getSelectedItem(),
                            checkDisponibilidad.isSelected()
                    );
                    listaUsuarios.add(usuario);

                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Correcto");
                    alerta.setContentText("Usuario agregado correctamente");
                    alerta.show();
                    limpiarCampos();
                }

            } else if (actionEvent.getSource() == buttonDetalle) {
                if (listViewUsuarios.getSelectionModel().getSelectedIndex() != -1) {
                    // Usuario usuarioSeleccionado = listViewUsuarios.getSelectionModel().getSelectedItem();
                    // System.out.println(usuarioSeleccionado);
                    // Stage -> ventanas
                    try {
                        Stage ventanaDetalle = new Stage();
                        ventanaDetalle.initModality(Modality.APPLICATION_MODAL);
                        ventanaDetalle.setTitle("Detalle del usuario");
                        // Scene -> escenas + Controller
                        // Node -> botones listas radios
                        FXMLLoader loader = new FXMLLoader(FormApplication.class.getResource("detail-view.fxml"));
                        Parent parent = null;
                        parent = loader.load();
                        ventanaDetalle.setScene(new Scene(parent));
                        ventanaDetalle.show();

                        // ((Stage)buttonDetalle.getScene().getWindow()).close();


                    } catch (IOException e) {
                        System.out.println("Error en la localizacion del fichero");
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("No hay elemento seleccionado");
                    alert.setTitle("Seleccion");
                    alert.show();
                }
            } else if (actionEvent.getSource() == buttonEliminar) {
                if (listViewUsuarios.getSelectionModel().getSelectedIndex() != -1) {
                    listaUsuarios.remove(listViewUsuarios.getSelectionModel().getSelectedIndex());
                    listViewUsuarios.getSelectionModel().select(-1);
                    // listViewUsuarios.getSelectionModel().select(null);

                }
            }
        }
    }
}
