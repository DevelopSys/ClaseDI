package org.example.gestor;

import java.sql.*;

public class UsuarioDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UsuarioDAO() {
        connection = new DBConnection().getConnection();
    }

    // metodos de la base de datos
    public boolean insertarUsuario(Usuario usuario) throws SQLException {
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES (?,?,?,?,?)"
                , SchemaDB.TAB_USER
                , SchemaDB.COL_NOM, SchemaDB.COL_AP, SchemaDB.COL_COR, SchemaDB.COL_PASS, SchemaDB.COL_ID_PER);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,usuario.getNombre());
        preparedStatement.setString(2,usuario.getApellido());
        preparedStatement.setString(3,usuario.getCorreo());
        preparedStatement.setString(4,usuario.getPass());
        preparedStatement.setInt(5,usuario.getId_perfil());
        boolean resultado = preparedStatement.execute();
        return resultado;

    }
    public void consultarUsuarios() throws SQLException {

        String query = String.format("SELECT * FROM %s", SchemaDB.TAB_USER);
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String correo = resultSet.getString(SchemaDB.COL_COR);
            System.out.println(correo);
        }
    }

}
