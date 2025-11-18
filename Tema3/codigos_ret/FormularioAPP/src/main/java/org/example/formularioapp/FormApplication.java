package org.example.formularioapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FormApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FormApplication.class.getResource("form-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Formulario contactos");
        stage.setScene(scene);
        stage.show();
    }
}
