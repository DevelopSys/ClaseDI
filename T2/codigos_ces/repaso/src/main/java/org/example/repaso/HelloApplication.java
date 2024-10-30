package org.example.repaso;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader
                        (HelloApplication.class.getResource("repaso-view.fxml"));
        Parent root = fxmlLoader.load();
        // play -> carga de la parte grafica
        Scene scene = new Scene(root, 400 , 400);
        stage.setTitle("Repaso");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}