package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorInicial implements Initializable {

    @FXML
    Button botonImagen, botonCambio;

    DropShadow sombraExterior;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        personalizarBotones();
        acciones();

    }

    private void instancias() {

        sombraExterior = new DropShadow();
    }

    private void acciones() {
        botonImagen.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonImagen.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        botonCambio.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());


    }

    private void personalizarBotones() {

        Image imagenOk = new Image(getClass().getResourceAsStream("resources/button_on.png"));
        botonImagen.setGraphic(new ImageView(imagenOk));
        botonImagen.setBackground(null);
        botonCambio.setGraphic(new ImageView
                (new Image(getClass().getResourceAsStream("resources/button_ok.png") )));
        botonCambio.setText("");
        botonCambio.setBackground(null);
        //botonImagen.setEffect(sombraExterior);
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

            // quien ha generado
                // que ha generado
            if (event.getSource() == botonImagen){
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    botonImagen.setEffect(sombraExterior);
                }else if (event.getEventType() == MouseEvent.MOUSE_EXITED){
                    botonImagen.setEffect(null);
                }
            } else if (event.getSource() == botonCambio){
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_cancel.png") )));
                    botonCambio.setEffect(sombraExterior);
                }else if (event.getEventType() == MouseEvent.MOUSE_EXITED){
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_ok.png") )));
                    botonCambio.setEffect(null);
                }
            }

            // que evento ha generado
                // quien lo ha hecho

        }
    }
}
