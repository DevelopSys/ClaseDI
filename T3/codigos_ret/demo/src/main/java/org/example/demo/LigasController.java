package org.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LigasController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private ComboBox<String> comboTemporadas;
    private ObservableList<String> listaTemporadas;

    @FXML
    private ListView<String> listViewClasificacion;

    @FXML
    private ListView<String> listViewLigas;

    @FXML private Button btnAnadir, btnBorrar, btnConsultar;

    private ObservableList<String> listaLigas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void acciones() {
        btnAnadir.setOnAction(this);
        btnBorrar.setOnAction(this);
        btnConsultar.setOnAction(this);
        listViewLigas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                System.out.println("La liga seleccionada es "+newValue);
            }
        });
    }

    private void instancias() {
        listaLigas = FXCollections.observableArrayList();
        listaLigas.addAll("Premier","Bundesliga","SerieA","BBVA La liga");
        listViewLigas.setItems(listaLigas);

        listaTemporadas = FXCollections.observableArrayList("2024-2025","2023-2022");
        comboTemporadas.setItems(listaTemporadas);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == btnBorrar) {
            /*int index = listViewLigas.getSelectionModel().getSelectedIndex();
            if (index<0){
                System.out.println("No hay seleccion");
            } else {
                // posicion
                listaLigas.remove(index);
                listViewLigas.getSelectionModel().select(-1);
                // seleccionado
                // listaLigas.remove(listViewLigas.getSelectionModel().getSelectedItem());
            }*/
            int index = comboTemporadas.getSelectionModel().getSelectedIndex();
            if (index>-1){
                listaTemporadas.remove(comboTemporadas.getSelectionModel().getSelectedItem());
            }

        }
        else if (event.getSource() == btnAnadir){
            listaTemporadas.add("2021-2022");
            // listaLigas.add("Liga nueva");
        } else if (event.getSource() == btnConsultar){
            String seleccionado = listViewLigas.getSelectionModel().getSelectedItem();
            System.out.println(seleccionado);
        }
    }
}
