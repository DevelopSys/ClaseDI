package dialogos;

import controladora.ControladoraPIntro;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogoIntro extends Application {

    ControladoraPIntro controladoraPIntro;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/dialogoIntro.fxml"));
        controladoraPIntro = loader.getController();
        //controladoraPIntro.setLista();
        Parent p = loader.load();
        Scene s = new Scene(p,300,200);
        primaryStage.setScene(s);
        primaryStage.setTitle("Diálogo Introducir");
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.showAndWait();
        //Parent root = FXMLLoader.load(getClass().getResource(""));
    }

    public ControladoraPIntro getControladoraPIntro() {
        return controladoraPIntro;
    }
}
