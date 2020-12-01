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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable {

    @FXML
    TableColumn columnaID, columnaNombre, columnaProducto, columnaLocalidad;

    @FXML
    Button botonAgregar, botonModificar, botonDetalle, botonEnviar;

    @FXML
    TableView<Pedido> tablaPedidos;

    ObservableList<Pedido> listaTabla, enviados;

    @FXML
    MenuItem menuExportar, menuSalir;

    @FXML
    ImageView imagen;

    int contador=0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        personalizarMenu();
        personalizarTabla();
        acciones();

    }

    private void personalizarTabla() {
        tablaPedidos.setItems(listaTabla);
        columnaID.setCellValueFactory(new PropertyValueFactory<>("numero"));
        columnaLocalidad.setCellValueFactory(new PropertyValueFactory<>("localidad"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));

        //listaTabla.addAll(new Pedido("Borja","Pozuelo","PS5",12,12));
    }

    private void personalizarMenu() {
        menuSalir.setAccelerator(KeyCombination.keyCombination("Ctrl + S"));
        menuExportar.setAccelerator(KeyCombination.keyCombination("Ctrl + E"));
        menuSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/salida.png"))));
        menuExportar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/enviar.png"))));
    }

    private void instancias() {
        imagen.setImage(new Image(getClass().getResourceAsStream("resources/amazon.png")));
        listaTabla = FXCollections.observableArrayList();
        enviados = FXCollections.observableArrayList();
    }

    private void acciones() {
        botonAgregar.setOnAction(new ManejoPulsaciones());
        botonDetalle.setOnAction(new ManejoPulsaciones());
        botonEnviar.setOnAction(new ManejoPulsaciones());
        botonModificar.setOnAction(new ManejoPulsaciones());
        menuExportar.setOnAction(new ManejoPulsaciones());
        menuSalir.setOnAction(new ManejoPulsaciones());
    }

    public void agregarProducto(Pedido pedido){
        // agregar el pedido a la tabla
        listaTabla.addAll(pedido);
        tablaPedidos.refresh();
    }
    public void modificarProducto(Pedido p) {

        for (Pedido item :listaTabla) {
            if (item.getNumero() == p.getNumero()){
                item.setProducto(p.getProducto());
                item.setNombre(p.getNombre());
                item.setLocalidad(p.getLocalidad());
                item.setTelefono(p.getTelefono());
            }
        }

    }


    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAgregar){

                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("agregar_layout.fxml"));


                try {
                    Parent root = loader.load();
                    ControllerAgregar controllerAgregar = loader.getController();
                    controllerAgregar.setControllerMain(ControllerMain.this,1, contador);
                    contador++;
                    Scene scene = new Scene(root,300,300);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if (actionEvent.getSource() == botonDetalle){

                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("agregar_layout.fxml"));


                try {
                    Parent root = loader.load();
                    ControllerAgregar controllerAgregar = loader.getController();
                    controllerAgregar.setControllerMain(ControllerMain.this,3,0);
                    controllerAgregar.detallePedido(tablaPedidos.getSelectionModel().getSelectedItem());
                    Scene scene = new Scene(root,300,300);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if (actionEvent.getSource() == botonEnviar){

                if (tablaPedidos.getSelectionModel().getSelectedIndex() < 0){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("No hay elemento seleccionado");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Eliminar?");
                    alert.setHeaderText("Lo quieres enviar");
                    Optional<ButtonType> opcion =  alert.showAndWait();
                    if (opcion.get() == ButtonType.OK){
                        enviados.add((Pedido) tablaPedidos.getSelectionModel().getSelectedItem());
                        listaTabla.remove(tablaPedidos.getSelectionModel().getSelectedIndex());
                        tablaPedidos.refresh();
                    }
                }

            }else if (actionEvent.getSource() == botonModificar){

                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("agregar_layout.fxml"));


                try {
                    Parent root = loader.load();
                    ControllerAgregar controllerAgregar = loader.getController();
                    controllerAgregar.setControllerMain(ControllerMain.this,2, 0);
                    controllerAgregar.comunicarPedido((Pedido) tablaPedidos.getSelectionModel().getSelectedItem());
                    Scene scene = new Scene(root,300,300);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else if (actionEvent.getSource() == menuSalir){

                Alert alertSalir = new Alert(Alert.AlertType.CONFIRMATION);
                alertSalir.setTitle("Saliendo....");
                alertSalir.setHeaderText("Estas seguro que quieres salir");
                Optional<ButtonType> opcion = alertSalir.showAndWait();
                if (opcion.get() == ButtonType.OK){
                    System.exit(0);
                }

            }else if (actionEvent.getSource() == menuExportar){
                FileChooser fileChooser = new FileChooser();
                File f = fileChooser.showSaveDialog(tablaPedidos.getScene().getWindow());
                if (f.getParentFile().canWrite()){
                    // FILE -- FILEWRITER -- BUFFERWRITER
                    FileWriter fileWriter;
                    BufferedWriter bufferedWriter;

                    try {
                        fileWriter = new FileWriter(f);
                        bufferedWriter = new BufferedWriter(fileWriter);
                        if (enviados.size() ==0){
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setHeaderText("No hay enviados");
                            alert.show();
                        } else {

                            for (Pedido item :enviados) {
                                bufferedWriter.write(item.toString());
                                bufferedWriter.newLine();
                            }

                            bufferedWriter.close();
                            fileWriter.close();

                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
