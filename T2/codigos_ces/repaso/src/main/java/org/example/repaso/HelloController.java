package org.example.repaso;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    public TextField textoCambiante;
    @FXML
    public Button botonMouse;
    @FXML
    private Label welcomeText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*textoCambiante.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                welcomeText.setText(t1.length()+"/255");
            }
        });*/
        botonMouse.setOnAction(this);
        botonMouse.setOnMouseEntered(new ManejoRaton());
        botonMouse.setOnMouseExited(new ManejoRaton());
        welcomeText.textProperty().bind(textoCambiante.textProperty());
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getSource() == botonMouse){
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                    System.out.println("Entrando");
                } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                    System.out.println("Saliendo");
                }
            }
        }
    }
}