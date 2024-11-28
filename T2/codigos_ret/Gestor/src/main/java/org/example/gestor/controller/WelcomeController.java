package org.example.gestor.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import org.example.gestor.MyApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {

    @FXML
    private Button btnComenzar;
    @FXML
    private ProgressBar barraProgreso;
    @FXML private Label txtCarga;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Task<Void> taskProgress = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // ejecucion en paralelo de la tarea -> llenar la barra

                for (int i = 0; i <= 100; i++) {
                    updateProgress(i,100);
                    updateMessage(String.format("Cargando %d %s",i,"%"));
                    Thread.sleep(20);
                }

                // cargar lo grafico -> task -> MAIN

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // creo una escena - FXML
                        FXMLLoader loader = new FXMLLoader(MyApp.class.getResource("login-view.fxml"));
                        try {
                            Parent parent = loader.load();
                            Scene registerScene = new Scene(parent, 500,300);
                            Stage nueva = new Stage();
                            nueva.setTitle("Login");
                            nueva.setScene(registerScene);
                            nueva.setResizable(false);
                            nueva.show();
                            ((Stage)btnComenzar.getScene().getWindow()).close();

                        } catch (IOException e) {
                            System.out.println("Vista no encontrada"); // ERROR 404
                        }
                    }
                });

                return null;
            }
        };

        // cuando la barra de progreso llegue
        // final aparezca una nueva ventaa con la escena del login-view

        barraProgreso.progressProperty().bind(taskProgress.progressProperty());
        txtCarga.textProperty().bind(taskProgress.messageProperty());

        btnComenzar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // comienza a llenarse la barra de progreso
                Thread thread = new Thread(taskProgress);
                thread.start();
            }
        });
    }
}