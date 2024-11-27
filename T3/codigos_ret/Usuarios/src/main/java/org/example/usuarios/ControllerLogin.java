package org.example.usuarios;

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
import org.example.usuarios.dao.UsuarioDAO;
import org.example.usuarios.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {


    @FXML
    private Button btnAccion;

    @FXML
    private RadioButton radioAcceder;

    @FXML
    private RadioButton radioRegistro;

    @FXML
    private TextField textMail;

    @FXML
    private TextField textpass;

    private ToggleGroup grupo;

    private UsuarioDAO usuarioDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instancias();
        acciones();

    }

    private void acciones() {
        grupo.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                btnAccion.setText(((RadioButton) newValue).getText());
            }
        });
        btnAccion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (grupo.getSelectedToggle() == radioAcceder) {

                        int id = usuarioDAO.getUsuarioLogin(textMail.getText(), textpass.getText());
                        if (id >=0){

                            FXMLLoader loader = new FXMLLoader(getClass().getResource("compras-view.fxml"));
                            Parent parent = loader.load();
                            ControllerCompra controllerCompra = loader.getController();
                            controllerCompra.setIdUsuario(id);
                            Scene scene = new Scene(parent);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.show();

                            ((Stage)btnAccion.getScene().getWindow()).close();

                        } else {
                            System.out.println("no hay usuario");
                        }

                    } else if (grupo.getSelectedToggle() == radioRegistro) {
                        usuarioDAO.registrar(textMail.getText(), textpass.getText());
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // login
                // registo
            }
        });

    }

    private void instancias() {
        usuarioDAO = new UsuarioDAO();
        grupo.getToggles().addAll(radioAcceder, radioRegistro);
    }
}
