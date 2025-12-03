package org.example.tienda.dao;

import javafx.scene.control.Alert;
import org.example.tienda.database.DBConnection;
import org.example.tienda.database.SchemaDB;
import org.example.tienda.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// solo digo como transacciona con base de datos
public class UsuarioDAOImp implements UsuarioDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void addUsuario(Usuario usuario) throws SQLException {
        connection = DBConnection.getConnection();
        // "INSERT INTO usuarios ("nombre","pass", "correo", idPerfil) VALUES ("asdasd","asdasdasd,"asasdasda",1)"
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                SchemaDB.TAB_NAME, SchemaDB.COL_NAME, SchemaDB.COL_MAIL, SchemaDB.COL_PASS, SchemaDB.COL_PROFILE);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getCorreo());
        preparedStatement.setString(3, usuario.getPass());
        preparedStatement.setInt(4, usuario.getIdPerfil());
        preparedStatement.executeUpdate();
    }

    @Override
    public int borrarUsuario(String nombre) {
        // DELETE FROM Usuarios WHERE nombre = ?
        connection = DBConnection.getConnection();
        String query = String.format("DELETE FROM %s WHERE %s = ?", "usuarios", "nombre");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }

        return -1;
    }

    @Override
    public boolean actualizarUsuario(int id, String correo) {
        return false;
    }

    @Override
    public ArrayList<Usuario> getUsuarios() {

        connection = DBConnection.getConnection();
        ArrayList<Usuario> lista = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                String pass = resultSet.getString("pass");
                int perfil = resultSet.getInt("id_perfil");
                Usuario usuario = new Usuario(nombre, correo, pass, perfil);
                lista.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Error de SQL");
        }

        return lista;
    }

    // SELECT id FROM USUARIOS WHERE CORREO=? AND PASS=?
    // ps.executeQuery -> resultSet
    // rs.next() -> true LOGIN
    // rs.next() -> false NOLOGIN
}
