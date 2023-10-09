package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {


    @FXML
    private GridPane gridBotones;
    @FXML
    private BorderPane bordeGeneral;

    @FXML
    private Button boton1;

    @FXML
    private Button boton2;

    @FXML
    private Button botonIgual;

    @FXML
    private Button botonMas;

    @FXML
    private TextField texcoCalculadora;

    // 1 suma
    // 2 resta
    // 3 multi
    // 4 div
    private int operandoUno, operandoDos, operacion;


    public void initialize(URL url, ResourceBundle resourceBundle) {

        acciones();

    }

    private void acciones() {
        for (Node item : gridBotones.getChildren()) {
            System.out.println(item);
            if (item instanceof Button) {
                ((Button) item).setOnAction(this);
            }
        }


    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // cuando algo se pulsa, se ejecutqa una parte de este metodo
        if (actionEvent.getSource() == boton1 || actionEvent.getSource() == boton2) {
            texcoCalculadora.appendText(((Button)actionEvent.getSource()).getText());
        } else if (actionEvent.getSource() == botonMas) {
            // guardar el contenido en operando1
            operandoUno = Integer.parseInt(texcoCalculadora.getText());
            operacion = 1;
            texcoCalculadora.setText("");
        } else if (actionEvent.getSource() == botonIgual) {
            operandoDos = Integer.parseInt(texcoCalculadora.getText());
            int resultado = 0;
            switch (operacion) {
                case 1:
                    resultado = operandoUno + operandoDos;
                    break;
                case 2:
                    resultado = operandoUno - operandoDos;
                    break;
                case 3:
                    resultado = operandoUno * operandoDos;
                    break;
                case 4:
                    resultado = operandoUno / operandoDos;
                    break;
            }
            texcoCalculadora.setText(String.valueOf(resultado));
        }
    }
}
