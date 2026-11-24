package org.example.examen1evdi.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class FavController implements Initializable {

    @FXML
    private ListView<String> listFavs;

    private ObservableList<String> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setLista(ObservableList<String> list) {
        this.list = list;
        listFavs.setItems(this.list);
    }
}
