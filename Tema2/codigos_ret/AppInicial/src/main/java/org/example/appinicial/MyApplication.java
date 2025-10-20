package org.example.appinicial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 1- FXMLLoader -> archivo fxml
        FXMLLoader loader = new FXMLLoader(MyApplication.class.getResource("vistas/main-view.fxml"));
        // 2- Cargar el FXML
        Parent root = loader.load();
        // 3- Crear el Scene
        Scene scene = new Scene(root);
        // 4- Poner la Scene en el Stage
        stage.setScene(scene);
        // 5- Poner titulo
        stage.setTitle("Ventana inicial");
        // 6- Mostrar ventana
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(MyApplication.class, args);
    }

}
