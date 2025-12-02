package org.example.tienda.dao;

import org.example.tienda.database.DBConnection;
import org.example.tienda.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

// solo digo como transacciona con base de datos
public class UsuarioDAOImp implements UsuarioDAO{

    private Connection connection;
    private PreparedStatement preparedStatement;
    @Override
    public void addUsuario(Usuario usuario) {
        connection = DBConnection.getConnection();
        // "INSERT INTO usuarios ("nombre","pass", "correo", idPerfil) VALUES ("asdasd","asdasdasd,"asasdasda",1)"
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                "usuarios","nombre","correo","pass","id_perfil");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,usuario.getNombre());
            preparedStatement.setString(2,usuario.getCorreo());
            preparedStatement.setString(3,usuario.getPass());
            preparedStatement.setInt(4,usuario.getIdPerfil());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int borrarUsuario(String nombre) {
        return 0;
    }

    @Override
    public boolean actualizarUsuario(int id, String correo) {
        return false;
    }

    @Override
    public ArrayList<Usuario> getUsuarios() {
        return null;
    }
}
