package org.example.tiendaapp.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.tiendaapp.TiendaApplication;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.User;

public class AdminController implements Initializable {


    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDetail, btnLogOut, btnRemove;

    @FXML
    private ListView<User> listViewUsers;
    // Lista -> ObservableList

    @FXML
    private Text txtAdmins, txtName, txtUsers;

    private User user;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initGUI();
        actions();
    }

    private void actions() {
        btnAdd.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(TiendaApplication.class.getResource("register-view.fxml"));
            try {
                Parent root = loader.load();
                RegisterController registerController = loader.getController();
                registerController.setAdminController(AdminController.this);
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnRemove.setOnAction(event -> {
            User userDel = listViewUsers.getSelectionModel().getSelectedItem();
            if (userDel == null) {
                System.out.println("No hay seleccion");
            } else {
                DataSet.removeUser(userDel);
                listViewUsers.getSelectionModel().select(null);
                refreshNumbers();
            }
        });
    }

    private void initGUI() {
        // total elementos de la lista
        listViewUsers.setItems(DataSet.getList());
        refreshNumbers();
    }

    public void refreshNumbers() {
        txtUsers.setText("El total de usuarios es de " + DataSet.getList().size());
        txtAdmins.setText("El total de admins es de " + DataSet.getAdmins());
    }


    public void setUser(String correo) {
        // busca y setea
        this.user = DataSet.getUser(correo);
        //System.out.println("Obtenido el correo "+correo);
        txtName.setText("Bienvenido " + user.getName());
    }
}
