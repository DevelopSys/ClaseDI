package org.example.gestor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button btnAcceder;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField edCorreo;

    @FXML
    private TextField edPAss;

    @FXML
    private RadioButton radioInvitado;

    @FXML
    private RadioButton radioUsuario;

    @FXML
    private BorderPane root;
    private ToggleGroup grupoRadios;
    private UsuarioDAO usuarioDAO;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        initGUI();
        acciones();

    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        usuarioDAO = new UsuarioDAO();
    }

    private void initGUI() {
        grupoRadios.getToggles().addAll(radioInvitado, radioUsuario);
    }

    private void acciones() {
        btnAcceder.setOnAction(this);
        btnRegistrar.setOnAction(this);
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                                Toggle old, Toggle tNew) {
                //System.out.println(((RadioButton)(tNew)).getText());
                //System.out.println(((RadioButton)(old)).getText());
                if (((RadioButton) tNew).getText().equalsIgnoreCase("usuario")) {
                    edCorreo.setEditable(true);
                    edPAss.setEditable(true);
                } else {
                    edCorreo.setEditable(false);
                    edPAss.setEditable(false);
                }
            }
        });
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnAcceder) {
            // String genero = ((RadioButton)(grupoRadios.getSelectedToggle())).getText();
            // System.out.println(genero);
            // saber si los camops estan rellenos
            // capturarlos y llevarlos a la base de datos -> DAO -> usuario
            // el usuario el null?
            // id_perfil -> 1 2 3
            int idPerfil = 2;
            String correo = "borja@gmail.com";
            FXMLLoader loader = null;
            Parent root = null;
            try {
                switch (idPerfil) {
                    case 1:
                        loader = new FXMLLoader(getClass().getResource("admin-view.fxml"));
                        root = loader.load();
                        AdminController adminController = loader.getController();
                        adminController.comunicarDatos(correo);
                        break;
                    case 2:
                        loader = new FXMLLoader(getClass().getResource("user-view.fxml"));
                        root = loader.load();
                        break;
                    case 3:
                        loader = new FXMLLoader(getClass().getResource("guest-view.fxml"));
                        root = loader.load();
                        break;
                }
                Scene scene = new Scene(root);
                Stage ventanaNueva = new Stage();
                ventanaNueva.setScene(scene);
                ventanaNueva.setTitle("Bienvenido borja");
                ventanaNueva.show();
                ((Stage) btnAcceder.getScene().getWindow()).close();
            } catch (IOException e) {
                // throw new RuntimeException(e);
            }



        } else if (actionEvent.getSource() == btnRegistrar) {

            try {
                //boolean resultado = usuarioDAO.insertarUsuario(new Usuario("Borja", "Martin", "correo@gmail.com", "1234", 2));
                //System.out.println(resultado);
                usuarioDAO.consultarUsuarios();
            } catch (SQLException e) {
                //System.out.println(e.getMessage());
                //System.out.println(e.getCause());

                System.out.println("Estas segudno que quieres volver a intentalo");
                // saltarle un cuadro de dialogo
            }
            /*
            // 1 saco la ventana actual
            Stage ventanaActual = (Stage) btnAcceder.getScene().getWindow();
            // 2 cargo el fxml en un FXMLLoader
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register-view.fxml"));
            // 3 activo el fxml
            try {
                Parent parent = loader.load();
                // 4. Crear la escena
                Scene sceneRegister = new Scene(parent,300,500);
                // 5. Pongo la escena en la ventana
                ventanaActual.setResizable(false);
                ventanaActual.setHeight(sceneRegister.getHeight());
                ventanaActual.setWidth(sceneRegister.getWidth());
                ventanaActual.setScene(sceneRegister);
                ventanaActual.setTitle("Registro");
            } catch (IOException e) {
                System.out.println("Error en la carga");
            }*/
        }

    }
}
