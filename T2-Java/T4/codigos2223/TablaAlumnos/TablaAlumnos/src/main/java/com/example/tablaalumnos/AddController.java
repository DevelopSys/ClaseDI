package com.example.tablaalumnos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @FXML
    private Button botonAgregar;

    @FXML
    private TextField campoCorreo;

    @FXML
    private TextField campoNombre;

    @FXML
    private TextField campoTelefono;

    private HelloController controller;

    @FXML
    private TextField camporApellido;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            botonAgregar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    String nombre = campoNombre.getText();
                    String apellido = camporApellido.getText();
                    String correo = campoCorreo.getText();
                    int telefono = Integer.valueOf(campoTelefono.getText());

                    controller.agregarElementos(new Alumno(0,nombre,apellido,correo,telefono));

                    Stage ventanaActual = (Stage) botonAgregar.getScene().getWindow();
                    ventanaActual.close();
                }
            });
    }

    public void setController(HelloController controller){
        this.controller = controller;
    }
}
