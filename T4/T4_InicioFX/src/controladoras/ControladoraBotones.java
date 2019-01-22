package controladoras;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraBotones implements Initializable {

    @FXML
    Button botonNormal;

    @FXML
    JFXButton botonMaterial;

    @FXML
    CheckBox checkNormal;

    @FXML
    JFXCheckBox checkMaterial;

    @FXML
    ToggleButton toggleNormal;

    @FXML
    JFXToggleButton toggleMaterial;

    @FXML
    RadioButton radioNormal, radioG1, radioG2, radioG3;

    @FXML
    JFXRadioButton radioMaterial;

    @FXML
    Label etiquetaCambio;

    @FXML
    BorderPane borderPane;

    DropShadow sombra;

    ToggleGroup grupo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        personalizaBotones();
        personalizaCheck();
        acciones();
    }

    private void personalizaCheck() {
        /*checkNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(checkNormal.isSelected());
            }
        });*/


        checkNormal.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        checkMaterial.setOnAction(new ManejoAction());

        radioNormal.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        radioMaterial.setOnAction(new ManejoAction());

        toggleNormal.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        toggleMaterial.setOnAction(new ManejoAction());

        grupo.getToggles().addAll(radioG1,radioG2,radioG3);

        /*grupo.getSelectedToggle().selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }
        });*/

        grupo.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                //System.out.println(newValue.toString());
                //((Persona)((RadioButton)newValue).getUserData()).getNombre();
                Persona p = (Persona) newValue.getUserData();
                //System.out.println(((Persona)((RadioButton)newValue).getUserData()).getNombre());
                System.out.println(p.getNombre());
            }
        });

        radioG1.setUserData(new Persona("Nombre1", "Apellido1",123));
        radioG2.setUserData(new Persona("Nombre2", "Apellido2",456));
        radioG3.setUserData(new Persona("Nombre3", "Apellido3",789));


    }

    private void personalizaBotones() {
        Image image = new Image(getClass().getResourceAsStream("/recursos/mas_64.png"));
        persoBoton(image, botonNormal);
    }

    private void acciones() {
        botonNormal.setOnAction(new ManejoAction());
        botonMaterial.setOnAction(new ManejoAction());
        botonNormal.setOnMouseExited(new ManejoRaton());
        botonNormal.setOnMouseEntered(new ManejoRaton());
        /*botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });*/
        /*borderPane.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });*/


    }

    private void instancias() {
        sombra = new DropShadow();
        grupo = new ToggleGroup();
    }

    public void persoBoton(Image image, Button b) {
        ImageView imageView = new ImageView(image);
        b.setGraphic(imageView);
        b.setText(null);
        b.setBackground(null);
        b.setBorder(null);
    }

    class ManejoAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == botonNormal) {
                etiquetaCambio.setText("Cambio desde el botón normal");
            } else if (event.getSource() == botonMaterial) {
                etiquetaCambio.setText("Cambio desde el botón material");
            } else if (event.getSource() == checkMaterial) {
                if (checkMaterial.isSelected()){
                    checkNormal.setSelected(true);
                }else {
                    checkNormal.setSelected(false);
                }
            } else if (event.getSource() == radioMaterial){
                if (radioMaterial.isSelected()){
                    radioNormal.setSelected(true);
                }else {
                    radioNormal.setSelected(false);
                }
            }else if (event.getSource() == toggleMaterial){
                if (toggleMaterial.isSelected()){
                    toggleNormal.setSelected(true);
                }else {
                    toggleNormal.setSelected(false);
                }
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (event.getSource() == botonNormal) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonNormal.setEffect(sombra);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    botonNormal.setEffect(null);
                }
            }
        }
    }
}
