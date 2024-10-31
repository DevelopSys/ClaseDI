package org.example.compras;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {
    @FXML
    public ImageView imagenLogo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imagenLogo.setImage(new Image(getClass().getResourceAsStream("amazon.png")));
        imagenLogo.setOpacity(0.0);
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    updateProgress(i,100);
                    Thread.sleep(50);
                }

                // arranco ventana
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // MAIN - JAVA FX
                        Stage actual = (Stage) imagenLogo.getScene().getWindow();
                        Stage nueva = new Stage();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("shop-view.fxml"));
                        try {
                            Parent parent = loader.load();
                            Scene scene= new Scene(parent,500,600);
                            nueva.setScene(scene);
                            nueva.show();
                            actual.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

                return null;
            }
        };


        Thread thread = new Thread(task);
        thread.start();

        imagenLogo.opacityProperty().bind(task.progressProperty());
    }
}
