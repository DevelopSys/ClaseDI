package controladora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControladorDialogos implements Initializable {


    @FXML
    Button bInformacion, bWarning, bError, bListas, bBoton, bConfirmacion, bEdicion;
    @FXML
    Label lInformacion, lWarning, lError, lListas, lBoton, lConfirmacion, lEdicion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
        bInformacion.setOnAction(new ManejoAcciones());
        bWarning.setOnAction(new ManejoAcciones());
        bError.setOnAction(new ManejoAcciones());
        bListas.setOnAction(new ManejoAcciones());
        bBoton.setOnAction(new ManejoAcciones());
        bConfirmacion.setOnAction(new ManejoAcciones());
        bEdicion.setOnAction(new ManejoAcciones());
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == bInformacion) {

                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("Título informacion");
                dialogoInfo.setHeaderText("Cabecera información");
                dialogoInfo.setContentText("Contenido información");
                dialogoInfo.showAndWait();
                /*if (opcion.get() == ButtonType.OK ){
                    Alert dialogoWar = new Alert(Alert.AlertType.WARNING);
                    dialogoWar.setTitle("Título warning");
                    dialogoWar.setHeaderText("Cabecera warning");
                    dialogoWar.setContentText("Contenido warning");
                    Optional<ButtonType> opcion2 = dialogoWar.showAndWait();
                    if (opcion2.get() == ButtonType.OK){
                        Alert dialogoError = new Alert(Alert.AlertType.ERROR);
                        dialogoError.setTitle("Título error");
                        dialogoError.setHeaderText("Cabecera error");
                        dialogoError.setContentText("Contenido error");
                        Optional<ButtonType> opciones = dialogoError.showAndWait();
                    }
                }*/

            } else if (event.getSource() == bWarning) {

                Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
                dialogoInfo.setTitle("Título warning");
                dialogoInfo.setHeaderText("Cabecera warning");
                dialogoInfo.setContentText("Contenido warning");
                dialogoInfo.showAndWait();

            } else if (event.getSource() == bError) {
                Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
                dialogoInfo.setTitle("Título error");
                dialogoInfo.setHeaderText("Cabecera error");
                dialogoInfo.setContentText("Contenido error");
                Optional<ButtonType> opciones = dialogoInfo.showAndWait();


            } else if (event.getSource() == bListas) {

                List<String> opciones = new ArrayList<>();
                opciones.add("opción 1");
                opciones.add("opción 2");
                opciones.add("opción 3");
                opciones.add("opción 4");

                ChoiceDialog<String> dialogoEleccion = new ChoiceDialog<String>(opciones.get(0), opciones);
                dialogoEleccion.setTitle("Diálogo de elección");
                dialogoEleccion.setHeaderText("Cabecera del cuadro de diálogo de elección");
                dialogoEleccion.setContentText("Contenido del cuadro de diálogo de elección");
                Optional<String> texto = dialogoEleccion.showAndWait();
                if (texto.isPresent()) {
                    lListas.setText(texto.get());
                }

            } else if (event.getSource() == bBoton) {

                Alert dialogoBotones = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoBotones.setTitle("Diálogo de confirmación");
                dialogoBotones.setHeaderText("Cabecera del cuadro de diálogo de confirmación");
                dialogoBotones.setContentText("Contenido del cuadro de diálogo de confirmación");
                ButtonType boton1 = new ButtonType("Botón 1");
                ButtonType boton2 = new ButtonType("Botón 2");
                ButtonType boton3 = new ButtonType("Botón 3");
                ButtonType boton4 = new ButtonType("Botón 4");
                dialogoBotones.getButtonTypes().addAll(boton1, boton2, boton3, boton4);
                Optional<ButtonType> opciones = dialogoBotones.showAndWait();

                if (opciones.get() == ButtonType.OK) {
                    lBoton.setText("Pulsado aceptar");
                } else if (opciones.get() == ButtonType.CANCEL) {
                    lBoton.setText("Pulsado cancelar");
                } else if (opciones.get() == boton1) {
                    lBoton.setText("Pulsado 1");
                } else if (opciones.get() == boton2) {
                    lBoton.setText("Pulsado 2");
                } else if (opciones.get() == boton3) {
                    lBoton.setText("Pulsado 3");
                } else if (opciones.get() == boton4) {
                    lBoton.setText("Pulsado 4");
                }


            } else if (event.getSource() == bConfirmacion) {
                Alert dialogoBotones = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoBotones.setTitle("Diálogo de confirmación");
                dialogoBotones.setHeaderText("Cabecera del cuadro de diálogo de confirmación");
                dialogoBotones.setContentText("Contenido del cuadro de diálogo de confirmación");
                Optional<ButtonType> opciones = dialogoBotones.showAndWait();

                if (opciones.get() == ButtonType.OK) {
                    lBoton.setText("Pulsado aceptar");
                } else if (opciones.get() == ButtonType.CANCEL) {
                    lBoton.setText("Pulsado cancelar");
                }

            } else if (event.getSource() == bEdicion) {

                TextInputDialog dialogoTexto = new TextInputDialog("Valor por defecto");
                dialogoTexto.setTitle("Diálogo de text input");
                dialogoTexto.setHeaderText("Cabecera del cuadro de diálogo de text input");
                dialogoTexto.setContentText("Contenido del cuadro de diálogo de text input");
                Optional<String> texto = dialogoTexto.showAndWait();
                if (texto.isPresent()) {
                    //System.out.println(texto.get());
                    lEdicion.setText(texto.get());
                }
            }
        }
    }


}
