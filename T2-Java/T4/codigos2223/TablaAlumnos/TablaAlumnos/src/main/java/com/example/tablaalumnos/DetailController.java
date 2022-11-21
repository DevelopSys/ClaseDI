package com.example.tablaalumnos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {


    @FXML
    private Button botonVolver;

    @FXML
    private Label campoApellido;

    @FXML
    private Label campoCorreo;

    @FXML
    private Label campoNombre;

    @FXML
    private Label campoTelefono;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            // poner en las etiquetas una serie de datos
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage ventanaActual = (Stage) botonVolver.getScene().getWindow();
                ventanaActual.close();
            }
        });

    }

    public void setearAlumno (Alumno alumno){
        campoNombre.setText(alumno.getNombre());
        campoApellido.setText(alumno.getApellido());
        campoCorreo.setText(alumno.getCorreo());
        campoTelefono.setText(String.valueOf(alumno.getTelefono()));
        // hacerlo desde un border o grid general
        //Stage ventanaActual = (Stage) campoTelefono.getScene().getWindow();
        //ventanaActual.setTitle("Detalle del alumno "+alumno.getNombre());
    }
}
