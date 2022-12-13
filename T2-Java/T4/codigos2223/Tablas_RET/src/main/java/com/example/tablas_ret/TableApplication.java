package com.example.tablas_ret;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TableApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TableApplication.class.getResource("table-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 750, 400);
        stage.setTitle("Aplicación Tabla");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}