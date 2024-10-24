package org.example.gestor;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {

    @FXML private Button boton;
    @FXML private ProgressBar barra;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                for (int i = 0; i <= 100 ; i++) {
                    updateProgress(i,100);
                    Thread.sleep(50);
                }

                System.out.println("Terminado");

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Scene sceneActual = boton.getScene();
                        Stage stageActual = (Stage) sceneActual.getWindow();
                        Stage stage = new Stage();
                        FXMLLoader loader = new FXMLLoader(WelcomeController.class.getResource("login-view.fxml"));
                        Parent root = null;
                        try {
                            root = loader.load();
                            Scene scene = new Scene(root,sceneActual.getWidth(),sceneActual.getHeight());
                            stage.setScene(scene);
                            stage.setTitle("Login APP");
                            stage.show();
                            stageActual.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });



                return null;
            }
        };

        barra.progressProperty().bind(task.progressProperty());
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // empiezar a rellenar la barra de progreso (0...1)
                Thread thread = new Thread(task);
                thread.start();
            }
        });
    }
}
