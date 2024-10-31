package org.example.compras;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

        // transcion 0 - 100 -> opacidad

        initGUI();

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    updateProgress(i,100);
                    Thread.sleep(20);
                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Stage actual = (Stage) imagenLogo.getScene().getWindow();
                        Stage nueva = new Stage();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("shop-view.fxml"));
                        try {
                            Scene scene = new Scene(loader.load(),500,500);
                            nueva.setTitle("Compras");
                            nueva.setScene(scene);
                            nueva.show();
                            actual.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

                // cambio pantalla

                return null;
            }
        };

        imagenLogo.opacityProperty().bind(task.progressProperty());
        Thread thread = new Thread(task);
        thread.start();

    }

    private void initGUI() {
        imagenLogo.setImage(new Image(getClass().getResourceAsStream("amazon.png")));
    }
}
