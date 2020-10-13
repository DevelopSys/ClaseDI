package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDos implements Initializable {

    @FXML
    Button botonVolver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        acciones();

    }

    private void acciones() {
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root,600,400);
                Stage stagePrincipal = (Stage) botonVolver.getScene().getWindow();
                stagePrincipal.setScene(scene);
            }
        });
    }
}
