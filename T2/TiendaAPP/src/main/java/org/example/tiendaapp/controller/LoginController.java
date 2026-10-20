package org.example.tiendaapp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.example.tiendaapp.data.DataSet;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class LoginController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button botonLogin, botonRegistro;

    @FXML
    private CheckBox checkRecordar;

    @FXML
    private TextField editCorreo, editPass;

    @FXML
    private Text textWarning;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // En caso de pulsar el boton Login, si los datos son correctos
            // en el texto -> login correcto
            // en el texto -> login fallido

        actions();
    }

    private void actions() {
        botonLogin.setOnAction(this);
        botonRegistro.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == botonLogin){
            String mail = editCorreo.getText();
            String pass = editPass.getText();
            int loginNumber = DataSet.getLogin(mail,pass);
            if (loginNumber!=-1){
                textWarning.setFill(Color.GREEN);
                textWarning.setText("Login correcto");
            } else {
                textWarning.setFill(Color.RED);
                textWarning.setText("Login incorrecto");
            }

        }else if (event.getSource() == botonRegistro){

        }
    }
}
