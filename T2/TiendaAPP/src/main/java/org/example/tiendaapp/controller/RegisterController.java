package org.example.tiendaapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.tiendaapp.TiendaApplication;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.User;

import javax.swing.*;
import java.io.IOException;
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
                // String selccionCombo  = comboProfile.getSelectionModel().getSelectedItem();
                int seleccionIndexCombo = comboProfile.getSelectionModel().getSelectedIndex();
                String nombre = editName.getText();
                String apellido = editSurname.getText();
                String pass = editPass.getText();
                String mail = editMail.getText();
                User user = new User(nombre,apellido,mail,pass, seleccionIndexCombo);
                if(DataSet.addUser(user)){
                    // ir al login
                    FXMLLoader loader = new FXMLLoader(TiendaApplication.class.getResource("login-view.fxml"));
                    Stage stage = (Stage) btnRegister.getScene().getWindow();
                    try {
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }else {

                }

            }
        });
    }
}
