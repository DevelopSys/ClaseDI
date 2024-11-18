package org.example.gestor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button btnRegistro, btnAcceso;

    @FXML
    private RadioButton radioInvitado, radioUsuario;

    @FXML
    private TextField editCorreo, editPass;

    private Stage stageActual;
    private Scene sceneActual;

    private ToggleGroup grupoRadios;
    private UsuarioDAO usuarioDAO;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ((Stage)(btnRegistro.getScene().getWindow())).setTitle("LOGIN");
        instancias();
        initGUI();
        acciones();

        Connection connection1 = new DBConnection().getConnection();

    }

    private void initGUI() {
        grupoRadios.getToggles().addAll(radioUsuario, radioInvitado);
    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        usuarioDAO = new UsuarioDAO();
    }

    private void acciones() {
        btnRegistro.setOnAction(this);
        btnAcceso.setOnAction(this);
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle old, Toggle tNew) {
                /*if (old != null) {
                    System.out.println("Eñ valor que estaba seleccionado es " + ((RadioButton) old).getText());
                }
                System.out.println("Eñ valor que esta seleccionado es " + ((RadioButton) tNew).getText());*/

                if (tNew == radioUsuario) {
                    editPass.setText("");
                    editCorreo.setText("");
                    editCorreo.setEditable(true);
                    editPass.setEditable(true);
                } else {
                    editCorreo.setEditable(false);
                    editPass.setEditable(false);
                }
            }
        });
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnRegistro) {
            sceneActual = btnRegistro.getScene();
            stageActual = (Stage) sceneActual.getWindow();
            // creo una escena - FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register-view.fxml"));
            try {
                Parent parent = loader.load();
                Scene registerScene = new Scene(parent, 500, 300);
                stageActual.setScene(registerScene);
                stageActual.setHeight(parent.prefHeight(-1));
                stageActual.setWidth(parent.prefWidth(-1));
                stageActual.setResizable(false);
                stageActual.setTitle("Registro");
            } catch (IOException e) {
                System.out.println("Vista no encontrada"); // ERROR 404
            }
            // cargo la scene en el stage actual
        } else if (actionEvent.getSource() == btnAcceso) {
            /*
            // para poder capturar el elemento seleccionado del togglegroup
            // RadioButton seleccion = (RadioButton) grupoRadios.getSelectedToggle();
            // System.out.println(seleccion.getText());
            Usuario usuario = new Usuario("Borja", "Martin",
                    "borja@correo.es", "1234", 123);

            try {
                // usuarioDAO.insertarUsuarioST(usuario);
                //usuarioDAO.insertarUsuarioPS(usuario);
                usuarioDAO.getUsuarios();
                /*System.out.println("El numero de usuarios  borrados es "
                        + usuarioDAO.borrarUsuarioTelefono(123));
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Error en la insercion. Queres hacer XXXX");
            }*/
            if (usuarioDAO.getUsuarioLogin("123", "coincide") != null) {


                //int idPerfil = usuarioDAO.getUsuarioLogin("123", "coincide").getIdPerfil();
                int idPerfil = 1;
                // depende del idPerfil la escena sera una u otra
                FXMLLoader loader;
                Parent root;

                try {
                    switch (idPerfil) {
                        case 1:
                            loader = new FXMLLoader(getClass().getResource("admin-view.fxml"));
                            root = loader.load();
                            break;
                        case 2:
                            loader = new FXMLLoader(getClass().getResource("user-view.fxml"));
                            root = loader.load();
                            break;
                        case 3:
                            loader = new FXMLLoader(getClass().getResource("guest-view.fxml"));
                            root = loader.load();
                            break;
                        default:
                            loader = new FXMLLoader(getClass().getResource("404-view.fxml"));
                            root = loader.load();
                    }
                    Scene scene = new Scene(root);
                    Stage ventana = new Stage();
                    ventana.setScene(scene);
                    ventana.show();

                    ((Stage) btnAcceso.getScene().getWindow()).close();


                } catch (IOException e) {
                    System.out.println("Error en l carga");
                }
            } else {
                System.out.println("No se puede hacer login");
            }


        }
    }
}
