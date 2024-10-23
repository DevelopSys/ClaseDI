package org.example.gestor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ParallelCamera;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button btnVolver;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Stage
                Stage stage = (Stage) btnVolver.getScene().getWindow();
                FXMLLoader loader  = new FXMLLoader(getClass().getResource("login-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root, stage.getWidth(),stage.getHeight());
                    stage.setScene(scene);
                } catch (IOException e) {
                    System.out.println("Carga incorrecta");
                }
            }
        });

    }
}
