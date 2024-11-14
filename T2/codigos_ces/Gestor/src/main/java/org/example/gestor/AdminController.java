package org.example.gestor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {


    @FXML
    private Button btnLista;
    @FXML
    private Label textoPerfil;

    @FXML
    private ListView<Usuario> listViewUsuarios;
    private ObservableList<Usuario> listaUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();

        listViewUsuarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observable, Usuario oldValue, Usuario newValue) {
                System.out.println(oldValue.getNombre());
                System.out.println(newValue.getNombre());
            }
        });
        btnLista.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // listaUsuarios.add(new Usuario("Nuevo","Apellido","correo@nuevo.com","1233",4));
                // no seleccion : -1
                /*int seleccionado = listViewUsuarios.getSelectionModel().getSelectedIndex();
                if (seleccionado != -1) {
                    listaUsuarios.remove(seleccionado);
                    listViewUsuarios.getSelectionModel().select(-1);
                }*/

                Usuario usuario = listViewUsuarios.getSelectionModel().getSelectedItem();
                System.out.println(usuario.getNombre());
            }
        });
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.addAll(
                new Usuario("Borja1", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja2", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja3", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja4", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja5", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja6", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja7", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja8", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja9", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja10", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja11", "Martin", "borja@gmail.com", "1234", 1),
                new Usuario("Borja12", "Martin", "borja@gmail.com", "1234", 1));
        listViewUsuarios.setItems(listaUsuarios);
    }

    public void comunicarDatos(String correo) {
        textoPerfil.setText(correo);
    }
}
