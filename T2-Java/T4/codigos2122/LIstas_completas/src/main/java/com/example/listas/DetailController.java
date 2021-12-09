package com.example.listas;

import com.example.listas.utils.Pelicula;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {

    @FXML
    private Label labelTitulo, labelDescripcion, labelPopularidad;

    @FXML
    private ImageView imagen;

    @FXML
    private Button botonContestar;

    private ListaController listaController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            botonContestar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    // quiero contestar a la ventana que me ha abierto, con
                    // un mensaje de "peticion procesada"
                    listaController.metodoContesar("Peticion procesada");
                    Stage ventana = (Stage) botonContestar.getScene().getWindow();
                    //ventana.setWidth(100);
                    //ventana.setHeight(100);
                    ventana.close();
                    
                }
            });
    }

    public void comunicarPelicula(Pelicula pelicula, ListaController listaController) {
        // hago con la pelicula lo que quiera
        this.listaController = listaController;
        labelTitulo.setText(pelicula.getTitulo());
        labelDescripcion.setText(pelicula.getDescripcion());
        labelPopularidad.setText(String.valueOf(pelicula.getPopularidad()));
        imagen.setImage(new Image(pelicula.getImagen()));

    }
}
