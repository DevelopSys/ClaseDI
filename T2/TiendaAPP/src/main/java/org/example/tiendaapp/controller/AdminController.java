package org.example.tiendaapp.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class AdminController implements Initializable {


    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDetail, btnLogOut, btnRemove;

    @FXML
    private ListView<?> listViewUsers;

    @FXML
    private Text txtAdmins,txtName, txtUsers;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
