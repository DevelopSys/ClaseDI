package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCalc implements Initializable, EventHandler<ActionEvent> {

    @FXML
    Button botonUno, botonDos, botonSuma, botonIgual;

    @FXML
    TextField textoCalc;

    @FXML
    GridPane panelBotones;

    boolean operando;
    int op1, op2, operacion, resultado;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();


    }

    private void instancias() {
        operando = false;
    }

    private void acciones() {

        ObservableList<Node> elementos = panelBotones.getChildren();
        /*for (Node item : elementos) {
            if (item instanceof Button) {
                ((Button) item).setOnAction(this);
            }
        }*/
        botonUno.setOnAction(this);
        botonDos.setOnAction(this);
        botonSuma.setOnAction(this);
        botonIgual.setOnAction(this);
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == botonUno) {
            if (!operando) {
                textoCalc.appendText(botonUno.getText());
            } else {
                textoCalc.setText(botonUno.getText());
            }
        } else if (actionEvent.getSource() == botonDos) {

            if (!operando) {
                textoCalc.appendText(botonUno.getText());
            } else {
                textoCalc.setText(botonUno.getText());
                operando = false;
            }

        } else if (actionEvent.getSource() == botonSuma) {

            op1 = Integer.parseInt(textoCalc.getText());
            operacion = 0;
            operando = true;


        } else if (actionEvent.getSource() == botonIgual) {
            op2 = Integer.parseInt(textoCalc.getText());

            switch (operacion) {
                case 0:
                    resultado = op1 + op2;

                    break;
                case 1:
                    resultado = op1 - op2;

                    break;
                case 2:
                    resultado = op1 * op2;

                    break;
                case 3:
                    resultado = op1 / op2;

                    break;
            }

            textoCalc.setText(String.valueOf(resultado));
        }
    }
}
