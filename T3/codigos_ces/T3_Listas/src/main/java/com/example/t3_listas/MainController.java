package com.example.t3_listas;


import com.example.t3_listas.model.Pelicula;
import com.example.t3_listas.model.PeliculaJSON;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class MainController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private ChoiceBox<Pelicula> choice;

    @FXML
    private ComboBox<String> combo;

    private ObservableList<String> listaCombo;

    private ObservableList<Pelicula> listaChoice;
    private ObservableList<PeliculaJSON> listaListView;

    @FXML
    private ListView<PeliculaJSON> listView;

    @FXML
    private BorderPane parteCentral;

    @FXML
    private Spinner<Integer> spinner;

    private SpinnerValueFactory<Integer> listaSpinner;

    @FXML
    private Button botonFiltrar;

    @FXML
    private RadioMenuItem manuDeshabilitar;

    @FXML
    private MenuItem menuAlerta;

    @FXML
    private RadioMenuItem menuHabilitar;

    @FXML
    private MenuItem menuPregunta;

    @FXML
    private MenuItem menuSalir;
    @FXML
    private MenuItem menuAgregar;

    @FXML
    private MenuItem menuEliminar;

    @FXML
    private MenuItem menuSeleccion;

    @FXML
    private MenuItem menuSimple;

    @FXML
    private MenuItem menuTexto;

    @FXML
    private MenuItem menuWarn;

    @FXML
    private MenuItem menuPersonalizado;

    private ToggleGroup grupoHabilitar;

    private DialogoPersoController dialogoPersoController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        //obtenerPeliculas();
        personalizarMenu();
        acciones();
    }

    private void obtenerPeliculas() {

        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=es-ES&page=1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea = reader.readLine()) != null) {
                stringBuffer.append(linea);
            }

            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray resultadoPeliculas = jsonObject.getJSONArray("results");
            // Iterable -> sin foreach
            for (int i = 0; i < resultadoPeliculas.length(); i++) {
                JSONObject pelicula = resultadoPeliculas.getJSONObject(i);
                String titulo = pelicula.getString("original_title");
                // sacar cada uno de los atributos y
                //PeliculaJSON peliculaJSON = new PeliculaJSON();
                Gson gson = new Gson();
                PeliculaJSON peliculaJSON = gson.fromJson(pelicula.toString(), PeliculaJSON.class);
                System.out.println(peliculaJSON.getBackdrop_path());
                listaListView.add(peliculaJSON);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void personalizarMenu() {
        menuSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("out.png"))));
        menuSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        menuSalir.setMnemonicParsing(true);

    }

    private void acciones() {
        grupoHabilitar.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (((RadioMenuItem) t1).getText().equalsIgnoreCase("habilitar")) {
                    parteCentral.setDisable(false);
                } else {
                    parteCentral.setDisable(true);
                }
            }
        });
        menuSalir.setOnAction(this);
        menuSimple.setOnAction(this);
        menuAlerta.setOnAction(this);
        menuWarn.setOnAction(this);
        menuSeleccion.setOnAction(this);
        menuPregunta.setOnAction(this);
        menuTexto.setOnAction(this);
        menuPersonalizado.setOnAction(this);
        botonFiltrar.setOnAction(this);
        menuAgregar.setOnAction(this);
        menuEliminar.setOnAction(this);
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue,
                                String s, String t1) {
                System.out.println(t1);
            }
        });
        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue,
                                Integer integer, Integer t1) {
                System.out.println(t1);
            }
        });


    }

    private void instancias() {
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("Terror", "Comedia", "Intriga", "Infantil");
        combo.setItems(listaCombo);
        listaChoice = FXCollections.observableArrayList();
        listaChoice.addAll(new Pelicula("Pelicula1", "terror", 1987)
                , new Pelicula("Pelicula2", "comedia", 2010)
                , new Pelicula("Pelicula3", "infantil", 2000));
        choice.setItems(listaChoice);

        listaListView = FXCollections.observableArrayList();
        listView.setItems(listaListView);

        listaSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 5, 5);
        /*ObservableList listaOpciones = FXCollections.observableArrayList();
        listaOpciones.addAll("Opcion 1","Opcion 2", "Opcion 3");
        listaSpinner = new SpinnerValueFactory.ListSpinnerValueFactory<>(listaOpciones);*/
        spinner.setValueFactory(listaSpinner);

        grupoHabilitar = new ToggleGroup();
        grupoHabilitar.getToggles().addAll(menuHabilitar, manuDeshabilitar);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == menuSalir) {
            System.exit(0);
        } else if (actionEvent.getSource() == menuSimple) {
            Alert alertSimple = new Alert(Alert.AlertType.INFORMATION);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de confirmacién simple");
            alertSimple.show();
        } else if (actionEvent.getSource() == menuWarn) {
            Alert alertSimple = new Alert(Alert.AlertType.WARNING);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de warning");
            alertSimple.show();
        } else if (actionEvent.getSource() == menuAlerta) {
            Alert alertSimple = new Alert(Alert.AlertType.ERROR);
            alertSimple.setTitle("Cuandro de alerta");
            alertSimple.setHeaderText("Cabecera del diálogo de confirmación");
            alertSimple.setContentText("Contenido del cuandro de diálogo de error");
            alertSimple.show();
        } else if (actionEvent.getSource() == menuPregunta) {
            Alert dialgoPregunta = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType botonUno = new ButtonType("Preguntar mas tarde");
            ButtonType botonDos = new ButtonType("Aplicar y esperar");
            //dialgoPregunta.getButtonTypes().addAll(botonUno,botonDos, ButtonType.APPLY);
            dialgoPregunta.getButtonTypes().setAll(botonUno, botonDos, ButtonType.APPLY);

            Optional<ButtonType> boton = dialgoPregunta.showAndWait();
            if (boton.get() == ButtonType.OK) {
                System.out.println("Pulsado ok");
            } else if (boton.get() == ButtonType.CANCEL) {
                System.out.println("Pulsado cancelar");
            } else if (boton.get() == botonUno) {
                System.out.println("Pulsado boton uno");
            } else if (boton.get() == ButtonType.APPLY) {
                System.out.println("Pulsado aplicar");
            }

        } else if (actionEvent.getSource() == menuSeleccion) {
            // elemento seleccionado, lista
            ObservableList<Pelicula> listaOpcionesObservable
                    = FXCollections.observableArrayList();
            //listaOpcionesObservable.addAll("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4");
            listaOpcionesObservable.addAll(new Pelicula("Titulo 1", "Genero 1", 1233)
                    , new Pelicula("Titulo 1", "Genero 1", 1233));
            ChoiceDialog<Pelicula> dialogChoice = new ChoiceDialog<>(listaOpcionesObservable.get(0)
                    , listaOpcionesObservable);
            Optional<Pelicula> respuesta = dialogChoice.showAndWait();

            if (respuesta.isPresent()) {
                System.out.println(respuesta.get().getGenero());
            } else {
                Alert alertaWarning = new Alert(Alert.AlertType.WARNING);
                alertaWarning.setHeaderText("Por favor introduce seleccion");
                alertaWarning.show();
            }
        } else if (actionEvent.getSource() == menuTexto) {
            TextInputDialog dialogoTexto = new TextInputDialog("Por favor introduce dato");
            Optional<String> respuesta = dialogoTexto.showAndWait();
            if (respuesta.isPresent()) {
                if (!respuesta.get().isEmpty()) {
                    System.out.println(respuesta.get());
                } else {
                    System.out.println("Introducidos datos vacios");
                }
            } else {
                System.out.println("Np hay datos");
            }

        } else if (actionEvent.getSource() == menuPersonalizado) {
            Dialog<Pelicula> dialogoPerso = new Dialog();
            dialogoPerso.setTitle("Cuadro personalizado");
            // VBOX
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dialogo-view.fxml"));
            System.out.println("Antes de cargar");
            Parent root = null;
            try {
                root = loader.load();
                dialogoPersoController = loader.getController();
                System.out.println("Despues de cargar");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dialogoPerso.getDialogPane().setContent(root);
            dialogoPerso.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CLOSE);
            dialogoPerso.setResultConverter(new Callback<ButtonType, Pelicula>() {

                @Override
                public Pelicula call(ButtonType buttonType) {
                    if (buttonType == ButtonType.APPLY) {
                        // necesito un objeto de tipo controladora (DialogoController)
                        // llamar al metodo getPelicula - isPelicula
                        if (dialogoPersoController.isPelicula()) {
                            return dialogoPersoController.getPelicula();
                        }
                    }
                    return null;
                }
            });
            Optional<Pelicula> respuesta = dialogoPerso.showAndWait();
            System.out.println(respuesta.get().getTitulo());
        } else if (actionEvent.getSource() == botonFiltrar) {

            //combo.getItems().get(1);
            /*
            if (combo.getSelectionModel().getSelectedIndex() != -1
                    && choice.getSelectionModel().getSelectedIndex() != -1
                    && listView.getSelectionModel().getSelectedIndex() != -1
            ) {
                //combo.getItems().get();
                System.out.println(combo.getSelectionModel().getSelectedItem());
                System.out.println(choice.getSelectionModel().getSelectedItem().getGenero());

                System.out.println(spinner.getValue());

            } else {
                System.out.println("No hay nada seleccionado");
            }*/
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    obtenerPeliculas();
                }
            });


        } else if (actionEvent.getSource() == menuAgregar) {

            listView.refresh();
        } else if (actionEvent.getSource() == menuEliminar) {
            if (listView.getSelectionModel().getSelectedIndex() > -1) {
                listaListView.remove(listView.getSelectionModel().getSelectedIndex());
                listView.refresh();
                listView.getSelectionModel().select(-1);
            } else {
                Alert aviso = new Alert(Alert.AlertType.WARNING);
                aviso.setHeaderText("No hay elemento seleccionado");
                aviso.show();
            }


        }

    }
}