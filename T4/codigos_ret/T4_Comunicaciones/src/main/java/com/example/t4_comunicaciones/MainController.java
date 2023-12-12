package com.example.t4_comunicaciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonComunicar;

    @FXML
    private TextField textoNombre;

    @FXML
    private Label textoObtenido;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonComunicar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // cargar el fxml
                FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("second-view.fxml"));
                try {
                    Stage ventanaActual = (Stage) botonComunicar.getScene().getWindow();
                    Parent root = loader.load();
                    SecondController controller = loader.getController();
                    controller.setNombre(textoNombre.getText());
                    controller.setMainController(MainController.this);
                    Scene scene = new Scene(root, ventanaActual.getWidth(), ventanaActual.getHeight());
                    Stage ventana = new Stage();
                    ventana.setScene(scene);
                    ventana.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void setRespuesta(String respuesta){
        textoObtenido.setText(textoNombre.getText()+" "+respuesta);
    }
}