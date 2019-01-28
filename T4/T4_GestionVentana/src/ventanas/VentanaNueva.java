package ventanas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaNueva extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("vista/ventananueva.fxml"));
        Scene scene = new Scene(root,600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
