package com.example.elementos;

import com.example.elementos.utils.Pelicula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DetalleController implements Initializable {

    @FXML
    Label tituloPelicula;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setearPelicula(Pelicula pelicula){
        tituloPelicula.setText(pelicula.getTitulo());
    }
}
