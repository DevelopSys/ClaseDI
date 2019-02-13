import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("vistas/multimedia.fxml"));
        Parent root = fxml.load();
        Scene sc = new Scene(root,600,400);
        primaryStage.setScene(sc);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Examen BD");
        primaryStage.show();
    }
}
