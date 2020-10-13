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
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button botonCambio, botonNuevas;
    DropShadow sombra;

    Scene segundaScena;
    Stage stagePrincipal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        acciones();

    }

    private void instancias() {
        sombra = new DropShadow();
    }

    private void acciones() {

        // gestiona acciones --> setOnAction
        botonCambio.setOnAction(new ManejoPulsaciones());
        botonNuevas.setOnAction(new ManejoPulsaciones());

        botonCambio.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNuevas.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNuevas.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        Image imagenOk = new Image(getClass().getResourceAsStream("resources/button_ok.png"));

        botonCambio.setBackground(null);
        botonCambio.setGraphic(new ImageView(imagenOk));

    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            //System.out.println("Boton pulsado");
            if (actionEvent.getSource() == botonCambio) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("second.fxml"));
                    segundaScena = new Scene(root, 600, 400);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                stagePrincipal = (Stage) botonCambio.getScene().getWindow();

                // Al pulsar boton --> en la ventana pongo la nueva scene
                stagePrincipal.setScene(segundaScena);
            } else if (actionEvent.getSource() == botonNuevas) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("ventana.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene scene = new Scene(root, 300, 300);
                Stage ventana = new Stage();
                ventana.setScene(scene);
                ventana.setTitle("Nueva ventana");
                ventana.show();
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                //botonCambio.setEffect(sombra);
                ((Button)mouseEvent.getSource()).setEffect(sombra);
                /*if (mouseEvent.getSource() == botonCambio){
                    botonCambio.setEffect(sombra);
                } else if (mouseEvent.getSource() == botonNuevas){
                    botonNuevas.setEffect(sombra);
                }*/


            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                //botonCambio.setEffect(null);
                ((Button)mouseEvent.getSource()).setEffect(null);
                /*if (mouseEvent.getSource() == botonCambio){
                    botonCambio.setEffect(null);
                } else if (mouseEvent.getSource() == botonNuevas){
                    botonNuevas.setEffect(null);
                }*/
            }
        }
    }



}


