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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController implements Initializable {


    @FXML
    private Button botonVolver;

    @FXML
    private Label labelScene2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
                try {
                    Parent root = loader.load();
                    // Crear scene
                    Scene scene = new Scene(root,botonVolver.getScene().getWidth()
                            ,botonVolver.getScene().getHeight());
                    // En el stage poner la scene
                    Stage stage = (Stage) botonVolver.getScene().getWindow();
                    stage.setScene(scene);
                    MainController controller = loader.getController();
                    controller.recuperarTexto("Texto recuperado");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void comunicarTexto(String texto){
        labelScene2.setText(texto);
    }
}
