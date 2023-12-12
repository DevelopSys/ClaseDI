package com.example.t4_comunicaciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private MenuItem menuPaso1;

    @FXML
    private MenuItem menuPaso2;

    @FXML
    private Label textoComunicado;

    @FXML
    private TextField textoApellido;

    @FXML
    private Button botonResponder;

    private MainController mainController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonResponder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                // comunicar
                mainController.setRespuesta(textoApellido.getText());
                // cerrar
                Stage ventana = (Stage) botonResponder.getScene().getWindow();
                ventana.close();
            }
        });

        menuPaso2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("vista-nueva.fxml"));
                try {
                    Parent root = loader.load();
                    Stage ventanaActual = (Stage) botonResponder.getScene().getWindow();
                    ventanaActual.setScene(new Scene(root,ventanaActual.getScene().getWidth(),
                            ventanaActual.getScene().getHeight()));
                    
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void setNombre(String nombre){
        textoComunicado.setText("El dato comunicado es: "+nombre);
    }

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }
}
