package org.example.usuarios.controller;

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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private Button btnAcceder;

    @FXML
    private RadioButton radioAcceder;

    @FXML
    private RadioButton radioRegistrar;

    @FXML
    private TextField textCorreo;

    @FXML
    private TextField textPass;
    private UsuarioDAO usuarioDAO;
    private ToggleGroup grupo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instancias();
        acciones();
    }

    private void acciones() {
        grupo.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                btnAcceder.setText(((RadioButton) newValue).getText());
            }
        });
        btnAcceder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (grupo.getSelectedToggle() == radioAcceder) {
                        if (usuarioDAO.getLoginUser(textCorreo.getText(), textPass.getText())){
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
                            try {
                                Parent parent = loader.load();
                                Scene scene = new Scene(parent);
                                Stage stage = new Stage();
                                stage.setScene(scene);
                                stage.show();
                                ((Stage)btnAcceder.getScene().getWindow()).close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    } else if (grupo.getSelectedToggle() == radioRegistrar) {
                        usuarioDAO.insertUser(textCorreo.getText(), textPass.getText());
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void instancias() {
        usuarioDAO = new UsuarioDAO();
        grupo = new ToggleGroup();
        grupo.getToggles().addAll(radioAcceder, radioRegistrar);
    }
}
