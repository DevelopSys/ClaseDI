package org.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.demo.model.Equipo;

import java.net.URL;
import java.util.ResourceBundle;

public class DetalleController implements Initializable {

    @FXML
    private ImageView imgEquipo;

    @FXML
    private Label txtClassificacion;

    @FXML
    private Label txtEmpatados;

    @FXML
    private Label txtGanados;

    @FXML
    private Label txtNombre;

    @FXML
    private Label txtPerdidos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getEquipo(Equipo equipo){
        imgEquipo.setImage(new Image(equipo.getStrBadge()));
        txtNombre.setText(equipo.getStrTeam());
        txtClassificacion.setText(equipo.getIntRank());
        txtGanados.setText(equipo.getIntWin());
        txtEmpatados.setText(equipo.getIntDraw());
        txtPerdidos.setText(equipo.getIntLoss());
    }
}
