package controladora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraParteDos implements Initializable {

    @FXML
    Button botonP2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        botonP2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Pulsado elemento parte dos");
            }
        });

    }
}
