package org.example.examen.dao;

import org.example.examen.database.DBConnection;
import org.example.examen.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public List<Producto> getProductos(String categoria) {
        connection = DBConnection.getConnection();
        List<Producto> lista = new ArrayList<>();
        String query = String.format("SELECT * FROM %s WHERE %s=?", "productos", "categoria");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, categoria);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String nombre = resultSet.getString("nombre");
                String categoriaP = resultSet.getString("categoria");
                String descripcion = resultSet.getString("descripcion");
                double precio = resultSet.getDouble("precion");
                Producto producto = new Producto(nombre, precio, categoria, descripcion);
                lista.add(producto);

            }
            return lista;

        } catch (SQLException e) {
            System.out.println("Error de SQL");
        }

        return lista;
    }

    public boolean getProductos() {
        connection = DBConnection.getConnection();
        List<Producto> lista = new ArrayList<>();
        String query = String.format("SELECT * FROM %s", "categoria");
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            System.out.println("Error de SQL");
        }

        return false;
    }

    public void insertarProducto() {
        ArrayList<Producto> lista = new ArrayList<>();
        // rellenar los productos con el txt que os pase
        connection = DBConnection.getConnection();
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)", "productos", "nombre", "precio", "categoria", "descripcion");
        for (Producto producto : lista) {
            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,producto.getNombre());
                preparedStatement.setDouble(2,producto.getPrecio());
                preparedStatement.setString(3,producto.getCategoria());
                preparedStatement.setString(4,producto.getDescripcion());
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
