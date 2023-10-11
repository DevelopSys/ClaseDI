package com.example.t2_estructura;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button botonAgregar, botonEmpezar;

    @FXML
    private Button botonObtener;

    @FXML
    private Button botonPulsar;

    @FXML
    private Label etiquetaGanador;

    @FXML
    private Label etiquetaParticipantes;

    private ArrayList<String> listaParticipantes;

    @FXML
    private TextField textoNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ejecuta directamente cuando se lee el atributo fx:controller
        listaParticipantes = new ArrayList<>();

        botonAgregar.setOnAction(this);
        botonObtener.setOnAction(this);
        botonEmpezar.setOnAction(this);
        botonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // sacar por consola el dato que esta dentro del textfield
                // "Perfecto, Borja, dato capturado"
                if (textoNombre.getText().length()>0){
                    System.out.printf("Perfecto %s dato capturado\n",textoNombre.getText());
                } else {
                    System.out.println("No hay datos");
                }
            }
        });
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // diferenciar quien ha pulsadoç
        if (actionEvent.getSource() == botonAgregar){
            //System.out.println("Boton agregar");
            if (textoNombre.getText().isEmpty()){
                System.out.println("No se puede agregar");
            } else {
                if (listaParticipantes.size() == 0){
                    botonEmpezar.setDisable(false);
                    etiquetaGanador.setText("");
                }
                listaParticipantes.add(textoNombre.getText());
                etiquetaParticipantes.setText("Nº de participantes: "+listaParticipantes.size());
                textoNombre.setText("");
            }

        }
        else if (actionEvent.getSource() == botonObtener){
            if (listaParticipantes.isEmpty()){
                etiquetaGanador.setText("No hay participantes");
            } else {// 8 [0-7]
                String ganador = listaParticipantes.get((int) (Math.random()*listaParticipantes.size()));
                etiquetaGanador.setText("El ganador es "+ganador);
            }
        }
        else if (actionEvent.getSource() == botonEmpezar){
            listaParticipantes.clear();
            etiquetaParticipantes.setText("Numero participantes 0");
            etiquetaGanador.setText("");
            botonEmpezar.setDisable(true);
        }
    }
}