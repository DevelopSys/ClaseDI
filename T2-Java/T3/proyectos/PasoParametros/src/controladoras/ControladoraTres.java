package controladoras;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladoraTres implements Initializable {

    @FXML
    Button botonP2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        botonP2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Ejemplo de pulsacion");
            }
        });
    }

}
