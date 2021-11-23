package com.example.elementos;

import com.example.elementos.utils.Pelicula;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DetalleController implements Initializable {

    @FXML
    Label tituloPelicula, detallePelicula;

    @FXML
    Button botonContestar;

    @FXML
    ImageView imagenPelicula;

    HelloController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       botonContestar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               //System.out.println(controller.imagenPelicula.toString());
               controller.metodoObtenerRespuesta("Te he contestado con esto");
               // Stage --> hide()
               
           }
       });
    }

    public void setearPelicula(Pelicula pelicula, HelloController helloController){
        this.controller = helloController;
        tituloPelicula.setText(pelicula.getTitulo());
        imagenPelicula.setImage(new Image("https://image.tmdb.org/t/p/w500"+pelicula.getImagen()));
        detallePelicula.setText(pelicula.getDescripcion());

    }
}
