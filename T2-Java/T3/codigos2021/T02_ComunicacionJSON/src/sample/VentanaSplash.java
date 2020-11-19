package sample;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaSplash implements Initializable {

    @FXML
    BorderPane nodoPrincipal;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Task tareaSecundaria = new Task() {
            @Override
            protected Object call() throws Exception {
                return null;
            }
        };

        tareaSecundaria.run();
        tareaSecundaria.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                try {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Parent root2 = FXMLLoader.load(getClass().getResource("ventana_principal.fxml"));
                    Stage secondStage = new Stage();
                    secondStage.setTitle("Ventana principal");
                    secondStage.setScene(new Scene(root2, 300, 275));
                    secondStage.show();
                    nodoPrincipal.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
