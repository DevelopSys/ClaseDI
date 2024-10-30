package org.example.repaso;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RepasoController implements Initializable {

    @FXML
    public Label textoProgreso;

    // variables
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    updateMessage(i+"%");
                    updateProgress(i,100);
                    Thread.sleep(10);
                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Stage actual = (Stage) textoProgreso.getScene().getWindow();
                        Stage stage = new Stage();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                        try {
                            Parent root = loader.load();
                            Scene scene = new Scene(root,320,200);
                            stage.setScene(scene);
                            stage.setTitle("Inicio");
                            stage.show();
                            actual.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

                return null;
            }
        };
        textoProgreso.textProperty().bind(task.messageProperty());
        Thread thread = new Thread(task);
        thread.start();
    }
}
