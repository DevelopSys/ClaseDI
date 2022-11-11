package com.example.repaso_uno;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import module.Equipo;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class RepasoController implements Initializable {

    @FXML
    ImageView imagenEquipo;

    @FXML
    private Label etiquetaEquipo;

    @FXML
    private RadioButton radioRayo;
    @FXML
    private RadioButton radioAtleti;
    @FXML
    private RadioButton radioMadrid;

    @FXML
    private ToggleGroup grupoEquipos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        acciones();
        asociarDatos();
    }

    private void asociarDatos() {
        radioRayo.setUserData(new Equipo("Rayo","http://www.escudosdefutbolyequipaciones.com/images_esc3/ESPA/MADRID/escudos_jpg/escudo-rayo%20vallecano.jpg","Vallecas"));
        radioAtleti.setUserData(new Equipo("Atleti","http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/42.png","Metropolitano"));
        radioMadrid.setUserData(new Equipo("Real Madrid","https://i.pinimg.com/originals/c1/5e/6d/c15e6d719debe4b3ed589c06045655dc.png","Santiago Vernabeu"));
    }

    private void acciones() {
        grupoEquipos.selectedToggleProperty().addListener( new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                Equipo seleccionado = (Equipo) ((RadioButton)t1).getUserData();
                imagenEquipo.setImage(new Image(seleccionado.getImagen()));
                etiquetaEquipo.setText(seleccionado.getCampo());
            }
        });
    }

    private void instancias() {

        grupoEquipos = new ToggleGroup();

        grupoEquipos.getToggles().addAll(radioAtleti,radioRayo,radioMadrid);
    }
}
