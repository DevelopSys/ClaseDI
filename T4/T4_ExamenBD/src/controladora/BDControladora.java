package controladora;

import basedatos.Conexion;
import basedatos.DatosBD;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import utils.Pelicula;
import utils.Serie;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BDControladora implements Initializable {

    @FXML
    Button filtroP, filtroS;

    @FXML
    ComboBox comboGeneroP, comboProtaP, comboGeneroS, comboCadenaS;

    @FXML
    ListView listaS, listaP;

    @FXML
    Label nombreS, generoS, cadenaS, temporadasS, nombreP, generoP, protaP, duracionP;

    ObservableList listaComboGeneroP, listaComboProtaP, listaComboGeneroS, listaComboCadenaS;

    ObservableList<Pelicula> listaPeliculas;

    ObservableList<Serie> listaSeries;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        rellenarCombos();
        rellenarListas();
        acciones();
    }

    private void acciones() {
        filtroP.setOnAction(new ManejoAcciones());
        filtroS.setOnAction(new ManejoAcciones());
        listaP.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Pelicula p = (Pelicula) newValue;
                nombreP.setText(p.getTitulo());
                protaP.setText(p.getProta());
                generoP.setText(p.getGenero());
                duracionP.setText(String.valueOf(p.getAnio()));
            }
        });

        listaS.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Serie p = (Serie) newValue;
                nombreP.setText(p.getTitulo());
                protaP.setText(p.getCadena());
                generoP.setText(p.getGenero());
                duracionP.setText(String.valueOf(p.getTemporadas()));
            }
        });
    }

    private void rellenarListas() {
        listaP.setItems(listaPeliculas);
        listaS.setItems(listaSeries);
    }

    private void rellenarGenerosP() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Connection connection = null;
                try {
                    connection = Conexion.dbConnector();
                    String query = "SELECT DISTINCT %s FROM %s";
                    ResultSet rs = connection.createStatement()
                            .executeQuery(String.format(query
                                    , DatosBD.TAB_PEL_GEN
                                    , DatosBD.TAB_PEL));

                    while (rs.next()) {
                        listaComboGeneroP.add(rs.getString(DatosBD.TAB_PEL_GEN));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
    }

    private void rellenarProtaP() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Connection connection = null;
                try {
                    connection = Conexion.dbConnector();
                    String query = "SELECT DISTINCT %s FROM %s";
                    ResultSet rs = connection.createStatement()
                            .executeQuery(String.format(query
                                    , DatosBD.TAB_PEL_PRO
                                    , DatosBD.TAB_PEL));

                    while (rs.next()) {
                        listaComboProtaP.add(rs.getString(DatosBD.TAB_PEL_PRO));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void rellenarGeneroS() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Connection connection = null;
                try {
                    connection = Conexion.dbConnector();
                    String query = "SELECT DISTINCT %s FROM %s";
                    ResultSet rs = connection.createStatement()
                            .executeQuery(String.format(query
                                    , DatosBD.TAB_SER_GEN
                                    , DatosBD.TAB_SER));

                    while (rs.next()) {
                        listaComboGeneroS.add(rs.getString(DatosBD.TAB_SER_GEN));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void rellenarCadenaS() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Connection connection = null;
                try {
                    connection = Conexion.dbConnector();
                    String query = "SELECT DISTINCT %s FROM %s";
                    ResultSet rs = connection.createStatement()
                            .executeQuery(String.format(query
                                    , DatosBD.TAB_SER_CAD
                                    , DatosBD.TAB_SER));

                    while (rs.next()) {
                        listaComboCadenaS.add(rs.getString(DatosBD.TAB_SER_CAD));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
    }

    private void instancias() {
        listaComboCadenaS = FXCollections.observableArrayList();
        listaComboGeneroP = FXCollections.observableArrayList();
        listaComboGeneroS = FXCollections.observableArrayList();
        listaComboProtaP = FXCollections.observableArrayList();
        listaPeliculas = FXCollections.observableArrayList();
        listaSeries = FXCollections.observableArrayList();
    }

    private void rellenarCombos() {
        comboCadenaS.setItems(listaComboCadenaS);
        comboGeneroS.setItems(listaComboGeneroS);
        comboGeneroP.setItems(listaComboGeneroP);
        comboProtaP.setItems(listaComboProtaP);
        listaComboProtaP.add(null);
        listaComboGeneroP.add(null);
        listaComboGeneroS.add(null);
        listaComboCadenaS.add(null);
        rellenarCadenaS();
        rellenarGeneroS();
        rellenarGenerosP();
        rellenarProtaP();
    }

    private void filtroP(Object genero, Object prota) throws SQLException {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                listaPeliculas.clear();
                String query = null;
                String queryCompleta = null;
                if (genero == null && prota == null) {
                    query = "SELECT * FROM %s";
                    queryCompleta = String.format(query, DatosBD.TAB_PEL);
                } else if (genero == null) {
                    query = "SELECT * FROM %s WHERE %s ='%s'";
                    queryCompleta = String.format(query, DatosBD.TAB_PEL
                            , DatosBD.TAB_PEL_PRO
                            , prota.toString());

                } else if (prota == null) {
                    query = "SELECT * FROM %s WHERE %s ='%s'";
                    queryCompleta = String.format(query, DatosBD.TAB_PEL
                            , DatosBD.TAB_PEL_GEN
                            , genero.toString());
                }
                Connection connection = null;
                try {
                    connection = Conexion.dbConnector();
                    ResultSet rs = connection.createStatement().executeQuery(queryCompleta);
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String titulo = rs.getString(DatosBD.TAB_PEL_TIT);
                        String gen = rs.getString(DatosBD.TAB_PEL_GEN);
                        String protag = rs.getString(DatosBD.TAB_PEL_PRO);
                        int anio = rs.getInt(DatosBD.TAB_PEL_AN);
                        Pelicula p = new Pelicula(id, titulo, gen, protag, anio);
                        listaPeliculas.add(p);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    private void filtroS(Object genero, Object cadena) throws SQLException {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                listaSeries.clear();
                String query = null;
                String queryCompleta = null;
                if (genero == null && cadena == null) {
                    query = "SELECT * FROM %s";
                    queryCompleta = String.format(query, DatosBD.TAB_SER);
                } else if (genero == null) {
                    query = "SELECT * FROM %s WHERE %s ='%s'";
                    queryCompleta = String.format(query, DatosBD.TAB_SER
                            , DatosBD.TAB_SER_CAD
                            , cadena.toString());

                } else if (cadena == null) {
                    query = "SELECT * FROM %s WHERE %s ='%s'";
                    queryCompleta = String.format(query, DatosBD.TAB_SER
                            , DatosBD.TAB_SER_GEN
                            , genero.toString());
                }
                Connection connection = null;
                try {
                    connection = Conexion.dbConnector();
                    ResultSet rs = connection.createStatement().executeQuery(queryCompleta);
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String titulo = rs.getString(DatosBD.TAB_PEL_TIT);
                        String gen = rs.getString(DatosBD.TAB_SER_GEN);
                        String cad = rs.getString(DatosBD.TAB_SER_CAD);
                        int temporadas = rs.getInt(DatosBD.TAB_SER_TEM);
                        Serie s = new Serie(id, titulo, gen, cad, temporadas);
                        listaSeries.add(s);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (SQLException e) {

                    }
                }

            }
        });
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == filtroP) {
                try {
                    filtroP(comboGeneroP.getSelectionModel().getSelectedItem()
                            , comboProtaP.getSelectionModel().getSelectedItem());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (event.getSource() == filtroS) {
                try {
                    filtroS(comboGeneroS.getSelectionModel().getSelectedItem()
                            , comboCadenaS.getSelectionModel().getSelectedItem());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
