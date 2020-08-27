package ventana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaInicial extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../layout/ventana_inicial.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JSON EJEMPLO");
        primaryStage.show();
    }

    public void lanzarVentana(){
        launch();
    }
}
