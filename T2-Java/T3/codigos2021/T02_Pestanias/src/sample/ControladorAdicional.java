package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.utils.Persona;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorAdicional implements Initializable {

    @FXML
    Label textoAdicional;

    @FXML
    Button botonVolver;

    private ControladorInicial controladorInicial;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Evento");
                // Controladora Inicial
                controladorInicial.terminarComunicacion("Volver terminado");
                // Stage(ventana) -> Scene(Parent --> FXML + Controller) -> Nodes
                botonVolver.getScene().getWindow().hide();
                //controladorInicial.cerrarVentana();
            }
        });
    }

    public void comunicarTexto(Persona persona, ControladorInicial controladorInicial){
        textoAdicional.setText(persona.getNombre());
        this.controladorInicial = controladorInicial;
    }
}
