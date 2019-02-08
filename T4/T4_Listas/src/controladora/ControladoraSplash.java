package controladora;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraSplash implements Initializable {

    FadeTransition fadeTransition;
    @FXML
    BorderPane border;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fadeTransition = new FadeTransition(Duration.millis(3000),border);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("terminado");
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../vista/listas.fxml"));
                    Scene scene = new Scene(root,600,400);
                    Stage stage = (Stage) border.getScene().getWindow();
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        fadeTransition.play();

    }
}
