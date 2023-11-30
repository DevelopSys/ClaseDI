package com.example.filtradoligas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogController implements Initializable {

    @FXML private ImageView imagenDetalle;
    @FXML private TextArea descripcionDetalle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setDetalle(Equipo equipo){
        imagenDetalle.setImage(new Image(equipo.strTeamBadge));
        descripcionDetalle.setWrapText(true);
        descripcionDetalle.setText(equipo.strDescriptionEN);
    }
}
