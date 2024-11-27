package org.example.usuarios.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.usuarios.dao.UsuarioDAO;
import org.example.usuarios.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.Predicate;

public class MainController implements Initializable {

    @FXML
    private Button btnDetalle;

    @FXML
    private TableColumn<?, ?> columnaId;

    @FXML
    private TableColumn<?, ?> columnaMail;

    @FXML
    private TableColumn<?, ?> columnaPass;

    @FXML
    private TableView<Usuario> tablaUsuarios;
    private FilteredList<Usuario> listaFiltrada;
    private UsuarioDAO usuarioDAO;

    @FXML
    private TextField textFiltro;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        acciones();
    }

    private void acciones() {
        textFiltro.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return usuario.getCorreo().contains(newValue);
                    }
                });
            }
        });
        btnDetalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("detail-view.fxml"));
                try {
                    Parent parent = loader.load();
                    DetailController detailController = loader.getController();
                    detailController.setUsuario(tablaUsuarios.getSelectionModel().getSelectedItem());
                    Scene scene = new Scene(parent);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void instancias() {
        try {
            columnaMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
            columnaPass.setCellValueFactory(new PropertyValueFactory<>("pass"));
            columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
            listaFiltrada = new FilteredList<>(usuarioDAO.getAllUsers());
            tablaUsuarios.setItems(listaFiltrada);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
