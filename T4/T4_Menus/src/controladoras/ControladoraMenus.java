package controladoras;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraMenus implements Initializable {

    @FXML
    MenuItem mIAbrir, mICerrar;

    @FXML
    RadioMenuItem mIRadio1, mIRadio2;

    @FXML
    CheckMenuItem mICheck2, mICheck1;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mIAbrir.setOnAction(new ManejoAccion());
        mICerrar.setOnAction(new ManejoAccion());
        mICheck1.setOnAction(new ManejoAccion());
        mICheck2.setOnAction(new ManejoAccion());
        mIRadio1.setOnAction(new ManejoAccion());
        mIRadio2.setOnAction(new ManejoAccion());
        mICheck1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("Seleccionado c1 "+ newValue);
            }
        });

    }

    class ManejoAccion implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == mIAbrir) {
                System.out.println("Pulsado abrir");
            } else if (event.getSource() == mICerrar) {
                System.out.println("Pulsado cerrar");
            } else if (event.getSource() == mICheck1) {
                if (mICheck1.isSelected()) {
                    System.out.println("Pulsado c1 seleccionado");
                } else
                    System.out.println("Pulsado c1 deseleccionado");

            } else if (event.getSource() == mICheck2) {
                if (mICheck2.isSelected()) {
                    System.out.println("Pulsado c2 seleccionado");
                } else
                    System.out.println("Pulsado c2 deseleccionado");
            } else if (event.getSource() == mIRadio1) {
                System.out.println("Pulsado r1");
            } else if (event.getSource() == mIRadio2) {
                System.out.println("Pulsado r2");
            }
        }
    }
}
