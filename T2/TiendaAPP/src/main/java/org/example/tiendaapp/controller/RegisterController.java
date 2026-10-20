package org.example.tiendaapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {

    @FXML
    private Button btnBack, btnRegister;
    @FXML
    private TextField editPass, editSurname, editName, editMail;
    @FXML
    private ObservableList<String> profileList;
    @FXML
    private ComboBox<String> comboProfile;
    private SpinnerValueFactory<Integer> numberModelValue;
    @FXML
    private Spinner<Integer> spinnerAge;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instances();
        initGUI();
        actions();
    }

    private void instances() {
        numberModelValue
                = new SpinnerValueFactory
                .IntegerSpinnerValueFactory(18,99,18,1);
        profileList = FXCollections.observableArrayList();
        profileList.addAll("Admin","Usuario");
    }

    private void initGUI() {
        // lista de elementos
        comboProfile.setItems(profileList);
        // modelo de elementos
        spinnerAge.setValueFactory(numberModelValue);
    }

    private void actions(){
        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int seleccionSpinner = spinnerAge.getValue();
                //String selccionCombo  = comboProfile.getValue();
                String selccionCombo  = comboProfile.getSelectionModel().getSelectedItem();
                int seleccionIndexCombo = comboProfile.getSelectionModel().getSelectedIndex();


                System.out.println("Spinner "+seleccionSpinner);
                System.out.println("Combo "+selccionCombo);
                System.out.println("Combo index"+seleccionIndexCombo);
            }
        });
    }
}
