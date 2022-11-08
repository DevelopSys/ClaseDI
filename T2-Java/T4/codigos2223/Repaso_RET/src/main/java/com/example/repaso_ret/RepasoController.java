package com.example.repaso_ret;

import com.example.repaso_ret.model.Equipo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RepasoController implements Initializable {


    @FXML
    private Label etiquetaEquipo;

    @FXML
    private ImageView imagen;

    @FXML
    private RadioButton radioRayo, radioAtleti, radioMadrid;

    @FXML
    private BorderPane borderGeneral;
    @FXML
    private GridPane gridLateral;

    // parte gráfica
    @FXML
    ListView<Equipo> listaRepaso;

    @FXML
    private ToggleButton toggleMostar;

    @FXML
    private Label labelCampo;

    private ToggleGroup grupoEquipos;

    // parte lógica
    private ObservableList<Equipo> lista;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        asociarDatos();
        acciones();
        initGUI();
        //botonInferior.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("francia.jpg"))));
        //imagen.setImage(new Image("http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/2.png"));
    }

    private void initGUI() {
        toggleMostar.setSelected(false);
        borderGeneral.getChildren().remove(gridLateral);
    }

    private void acciones() {

        toggleMostar.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    borderGeneral.setLeft(gridLateral);
                    //lista.remove(lista.size()-1);
                } else {
                    //borderGeneral.getChildren().remove(gridLateral);
                    //lista.add(new Equipo("ejemplo","",""));
                    lista.remove(listaRepaso.getSelectionModel().getSelectedIndex());
                }
            }
        });
        grupoEquipos.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                Equipo seleccionado = (Equipo) ((RadioButton) t1).getUserData();
                imagen.setImage(new Image(seleccionado.getImage()));
                //etiquetaEquipo.setText(seleccionado.getCampo());
                if (seleccionado.getNombre().equalsIgnoreCase("real madrid")) {
                    toggleMostar.setSelected(true);
                } else {
                    toggleMostar.setSelected(false);
                }
            }
        });

        listaRepaso.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Equipo>() {
            @Override
            public void changed(ObservableValue<? extends Equipo> observableValue,
                                Equipo equipo, Equipo t1) {
                //System.out.println(t1.getCampo());
                labelCampo.setText(t1.getCampo());
            }
        });
    }

    private void asociarDatos() {
        radioRayo.setUserData(new Equipo("Rayo Vallecano",
                "http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/2.png",
                "Vallecas"));
        radioMadrid.setUserData(new Equipo("Real Madrid",
                "http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/1.png",
                "Bernabeu"));
        radioAtleti.setUserData(new Equipo("Atletico de Madrid",
                "https://i.pinimg.com/736x/34/d8/55/34d855a5e063ea145a4804b2d1c24e7d--madrid-soccer.jpg",
                "Metropolitano"));

        listaRepaso.setItems(lista);
    }

    private void instancias() {
        grupoEquipos = new ToggleGroup();
        grupoEquipos.getToggles().addAll(radioRayo, radioMadrid, radioAtleti);
        lista = FXCollections.observableArrayList();
        lista.addAll(new Equipo("R.Madrid", "", "Bernabeu")
                , new Equipo("Rayo", "", "Vallecas")
                , new Equipo("Atleti", "", "Metropilitano")
        );
    }
}
