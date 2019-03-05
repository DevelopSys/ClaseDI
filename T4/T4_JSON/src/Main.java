import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/main.fxml"));
        Parent root = loader.load();
        Scene sc = new Scene(root,600,400);
        primaryStage.setScene(sc);
        primaryStage.show();

    }
}
