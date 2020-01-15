package controladoras;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Persona;
import ventanas.VentanaDos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVentanaUno implements Initializable {

    DropShadow sombra = new DropShadow();

    @FXML
    Button btnNormal, btnImagen, botonPantalla;

    @FXML
    Tab tabBotones, tabTextos;

    @FXML
    CheckBox check;

    @FXML
    RadioButton radioUno, radioDos, radioTres;

    @FXML
    JFXTextField textoMaterial;

    @FXML
    TextArea textoArea;

    ToggleGroup grupoRadios;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //textoArea.setWrapText(true);
        instancias();
        personalizarBoton();
        acciones();
    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        radioUno.setUserData(new Persona("Borja", "casado"));
        radioDos.setUserData(new Persona("Jose", "soltero"));
        radioTres.setUserData(new Persona("Luis", "casado"));
        grupoRadios.getToggles().addAll(radioUno, radioDos, radioTres);
    }

    private void personalizarBoton() {

        btnImagen.setBackground(null);
        btnImagen.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("../resources/button_ok.png"))));
    }

    private void acciones() {

        botonPantalla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VentanaDos ventanaDos = new VentanaDos(textoMaterial.getText());

            }
        });

        btnNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(check.isSelected());
                //grupoRadios.getSelectedToggle();
            }
        });
        btnNormal.setOnMouseEntered(new ManejoRaton());
        btnNormal.setOnMouseExited(new ManejoRaton());
        btnImagen.setOnMousePressed(new ManejoRaton());
        btnImagen.setOnMouseReleased(new ManejoRaton());
        check.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    btnNormal.setDisable(true);
                } else {
                    btnNormal.setDisable(false);
                }
            }
        });
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                Persona seleccionado = (Persona) newValue.getUserData();
                System.out.println(seleccionado.getEstado()
                );
            }
        });
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (event.getSource() == btnNormal) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    btnNormal.setEffect(sombra);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    btnNormal.setEffect(null);
                }
            } else if (event.getSource() == btnImagen) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    btnImagen.setEffect(sombra);
                } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    System.out.println("soltado");
                    btnImagen.setEffect(null);
                }
            }
        }
    }
}
