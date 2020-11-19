package sample;

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
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.utils.Persona;

import java.io.*;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Diálogos - Files - Comunicación

    @FXML
    MenuItem menuAlerta, menuConfirmacion, menuInput, menuChoice, menuAbrir, menuGuardar, menuOrigen, menuDestino;

    @FXML
    BorderPane borderGeneral;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        acciones();

    }

    private void acciones() {
        menuAbrir.setOnAction(new ManejoPulsacion());
        menuAlerta.setOnAction(new ManejoPulsacion());
        menuChoice.setOnAction(new ManejoPulsacion());
        menuConfirmacion.setOnAction(new ManejoPulsacion());
        menuDestino.setOnAction(new ManejoPulsacion());
        menuGuardar.setOnAction(new ManejoPulsacion());
        menuInput.setOnAction(new ManejoPulsacion());
        menuOrigen.setOnAction(new ManejoPulsacion());
    }

    class ManejoPulsacion implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource() == menuAlerta) {
                Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
                dialogoAlerta.setTitle("Titulo del cuadro");
                dialogoAlerta.setHeaderText("Cabecera del cuadro");
                dialogoAlerta.setContentText("Contenido del cuadro");
                dialogoAlerta.show();
            } else if (actionEvent.getSource() == menuInput) {
                TextInputDialog dialogoInput = new TextInputDialog("nombre");
                dialogoInput.setTitle("Titulo del cuadro");
                dialogoInput.setHeaderText("Cabecera del cuadro");
                dialogoInput.setContentText("Contenido del cuadro");
                try {
                    Optional<String> seleccion = dialogoInput.showAndWait();
                    System.out.println(seleccion.get());
                } catch (NoSuchElementException e) {
                    System.out.println("Sin valor introducido");
                }

            } else if (actionEvent.getSource() == menuChoice) {
                ObservableList listaChoice = FXCollections.observableArrayList();
                listaChoice.addAll(new Persona("Borja", "Martin", "Getafe"));
                listaChoice.addAll(new Persona("Luis", "Martin", "Pozuelo"));
                listaChoice.addAll(new Persona("Alberto", "Martin", "Leganes"));
                listaChoice.addAll(new Persona("Samu", "samu", "Alcorcon"));
                ChoiceDialog<Persona> dialogoChoice = new ChoiceDialog(listaChoice.get(0), listaChoice);
                dialogoChoice.setTitle("Titulo del cuadro");
                dialogoChoice.setHeaderText("Cabecera del cuadro");
                dialogoChoice.setContentText("Contenido del cuadro");
                Optional<Persona> seleccion = dialogoChoice.showAndWait();
                System.out.println(seleccion.get().getDireccion());

            } else if (actionEvent.getSource() == menuConfirmacion) {

                Alert dialogoConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoConfirmacion.setTitle("Titulo del cuadro");
                dialogoConfirmacion.setHeaderText("Cabecera del cuadro");
                dialogoConfirmacion.setContentText("Contenido del cuadro");
                ButtonType botonUno = new ButtonType("Opcion 1");
                ButtonType botonDos = new ButtonType("Opcion 2");
                dialogoConfirmacion.getButtonTypes().setAll(botonUno, botonDos);

                Optional<ButtonType> seleccion = dialogoConfirmacion.showAndWait();
                if (seleccion.get() == botonUno) {
                    System.out.println("OPCION 1");
                } else if (seleccion.get() == botonDos) {
                    System.out.println("OPCION 2");
                } else if (seleccion.get() == ButtonType.CANCEL) {
                    System.out.println("CANCELAR");
                }


            } else if (actionEvent.getSource() == menuAbrir) {
                FileChooser dialogoAbrir = new FileChooser();
                File file = dialogoAbrir.showOpenDialog(borderGeneral.getScene().getWindow());
                if (file.canRead()) {
                    // FILE --> FILEREADER --> BUFFEREDREADER
                    //
                    FileReader fileReader;
                    BufferedReader bufferedReader;

                    try {
                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                        String linea;
                        while((linea = bufferedReader.readLine())!=null){
                            System.out.println(linea);
                        }
                        /*do {
                            linea = bufferedReader.readLine();
                            System.out.println(linea);
                            linea = bufferedReader.readLine();
                        } while (linea!=null);*/
                       /* do{
                            lectura = fileReader.read();
                            System.out.println(lectura);
                            lectura = fileReader.read();
                        }while(lectura!=-1);*/

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } else if (actionEvent.getSource() == menuGuardar) {
                FileChooser dialogoGuardar = new FileChooser();
                File file = dialogoGuardar.showSaveDialog(borderGeneral.getScene().getWindow());
                // FILE --> FILEWRITER --> BUFFEREDWRITER
                String frase = "Hola esto es un ejemplo para poder guardar en un fichero";
                String[] palabras = frase.split(" ");
                if (file.getParentFile().canWrite()){
                    FileWriter fileWriter;
                    BufferedWriter bufferedWriter;

                    try {
                        fileWriter = new FileWriter(file);
                        bufferedWriter = new BufferedWriter(fileWriter);
                        for (int i = 0; i < palabras.length; i++) {
                            bufferedWriter.write(palabras[i]);
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            } else if (actionEvent.getSource() == menuOrigen) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("ventana_adicional.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                VentanaAdicional ventanaAdicional = loader.getController();
                ventanaAdicional.comunicarTexto("Comunicación OK");


                Scene scene = new Scene(root,300,300);
                Stage ventana = new Stage();
                ventana.setScene(scene);
                ventana.show();

                //borderGeneral.getScene().getWindow().hide();



            } else if (actionEvent.getSource() == menuDestino) {



            }
        }
    }
}



