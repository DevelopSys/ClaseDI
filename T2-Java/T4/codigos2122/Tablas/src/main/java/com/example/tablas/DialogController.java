package com.example.tablas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DialogController implements Initializable, EventHandler<ActionEvent> {


    @FXML
    private MenuItem menuTablas, menuDialogos;

    @FXML
    private BorderPane borderPane;

    @FXML
    Button btnInfo, btnWarning, btnConfirm, btnChoice, btnInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        menuTablas.setOnAction(this);
        btnConfirm.setOnAction(this);
        btnInfo.setOnAction(this);
        btnInput.setOnAction(this);
        btnWarning.setOnAction(this);
        btnChoice.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource() == menuTablas) {
            System.out.println("Seleccionado menu tablas");
            Stage stage = (Stage) borderPane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(AppController.class.getResource("app-view.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage.setWidth(root.getScene().getWidth());
            stage.setHeight(root.getScene().getHeight());

            stage.setScene(scene);
        }
        else if (actionEvent.getSource() == btnChoice) {

            ChoiceDialog choiceDialog = new ChoiceDialog();
            choiceDialog.getItems().addAll(1,23,123,123,124,23,54);
            choiceDialog.setTitle("Titulo diálogo choice");
            choiceDialog.setHeaderText("Header diálogo choice");
            choiceDialog.setContentText("Content diálogo choice");

            Optional<Integer> contestacion = choiceDialog.showAndWait();

            if (contestacion.get()!=null){
                System.out.println(contestacion.get());
            }

        } else if (actionEvent.getSource() == btnConfirm) {

            Alert dialogInfo = new Alert(Alert.AlertType.CONFIRMATION);
            dialogInfo.setTitle("Confirmacion");
            dialogInfo.setHeaderText("Header Confirmacion");
            dialogInfo.setContentText("Mensaje Confirmacion");
            ButtonType botonMio = new ButtonType("OK_MIO");
            dialogInfo.getButtonTypes().setAll(botonMio,ButtonType.FINISH, new ButtonType("CANCEL_MIO"));

            Optional<ButtonType> constestacion = dialogInfo.showAndWait();
            System.out.println(constestacion);
            if (constestacion.get() == botonMio){
                System.out.println("Boton aceptar mio pulsado");
            } else {
                System.out.println("Boton cancelar pulsado");
            }

        } else if (actionEvent.getSource() == btnInfo) {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cuadro de diálogo de información");
            dialogoInfo.setHeaderText("Header de información");
            dialogoInfo.setContentText("Contenido de información");
            dialogoInfo.showAndWait();

        } else if (actionEvent.getSource() == btnInput) {

            TextInputDialog textInputDialog = new TextInputDialog();
            textInputDialog.setTitle("Titulo dialogo input");
            textInputDialog.setHeaderText("Header dialogo input");
            textInputDialog.setContentText("Contenido dialogo input");
            Optional<String> contestacion = textInputDialog.showAndWait();
            System.out.println(contestacion.get());

        } else if (actionEvent.getSource() == btnWarning) {
            Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
            dialogoInfo.setTitle("Cuadro de diálogo de warning");
            dialogoInfo.setHeaderText("Header de warning");
            dialogoInfo.setContentText("Contenido de warning");
            dialogoInfo.showAndWait();
        }
    }
}
