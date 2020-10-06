package ventanas;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaInicial extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root= FXMLLoader.load(getClass().getResource("../layouts/ventana_inicial.fxml"));
        Scene scene = new Scene(root, 300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
