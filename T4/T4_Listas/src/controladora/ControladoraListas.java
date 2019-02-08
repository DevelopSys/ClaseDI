package controladora;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraListas implements Initializable {

    ObservableList<Persona> listaCombo, listaComboMaterial, listaChoice, listaListView;

    @FXML
    ComboBox comboNormal;
    @FXML
    ChoiceBox choiceNormal;
    @FXML
    JFXComboBox comboMaterial;
    @FXML
    ListView listaNormal;
    @FXML
    JFXListView listaMaterial;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        rellenarListas();
        rellenarListView();
        acciones();
    }

    private void rellenarListView() {
        listaListView = FXCollections.observableArrayList();

        listaListView.add(new Persona("nombre1", "apellido", 132));
        listaListView.add(new Persona("nombre2", "apellido", 132));
        listaListView.add(new Persona("nombre3", "apellido", 132));
        listaListView.add(new Persona("nombre4", "apellido", 132));
        listaNormal.setItems(listaListView);
        //listaNormal.getSelectionModel().select(0);
        //((Persona)listaNormal.getSelectionModel().getSelectedItem()).getNombre();
        //listaNormal.getSelectionModel().getSelectedItems();
        listaNormal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Persona p = (Persona) newValue;
                System.out.println(p.getApellido());
            }
        });

        listaMaterial.setItems(listaListView);
        listaMaterial.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Persona p = (Persona) newValue;
                System.out.println(p.getApellido());
            }
        });
    }

    private void acciones() {
        /*comboNormal.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.ENTER){
                    listaCombo.add(new Persona(comboNormal.getEditor().getText(),"",234));
                    System.out.println("pulsada tecla");
                }
            }
        });*/
    }

    private void rellenarListas() {
        listaCombo.add(new Persona("nombre1", "apellido", 132));
        listaCombo.add(new Persona("nombre2", "apellido", 132));
        listaCombo.add(new Persona("nombre3", "apellido", 132));
        listaCombo.add(new Persona("nombre4", "apellido", 132));
        //listaCombo.addAll(new Persona("","",2123),new Persona("","",12));
        comboNormal.setItems(listaCombo);
        comboNormal.setValue(listaCombo.get(0));
        //comboNormal.setEditable(true);
        Persona a = (Persona) comboNormal.getSelectionModel().getSelectedItem();
        //System.out.println(a.getTelefono());
        comboNormal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(((Persona) newValue).getTelefono());
            }
        });

        comboMaterial.setItems(listaCombo);
        comboMaterial.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(((Persona) newValue).getTelefono());
            }
        });


    }

    private void instancias() {
        listaCombo = FXCollections.observableArrayList();
        listaComboMaterial = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
    }
}
