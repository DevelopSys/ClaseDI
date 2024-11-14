package org.example.gestor;

import java.sql.*;

public class UsuarioDAO {

    // CRUD

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public UsuarioDAO() {
        connection = new DBConnection().getConnection();
    }

    // CREATE - UPDATE - DELETE
    // INSERT CON STATEMENT
    public void insertarUsuarioST(Usuario usuario) throws SQLException {

        // NO PIDO LOS DATOS
        statement = connection.createStatement();
        // INSERT INTO usasda (asd,asd,asda,sd) VALUES ('asdasd','asd',asd,asd,)
        String query = "INSERT INTO %s (%s,%s,%s,%s,%s,%s) " +
                "VALUES ('%s','%s','%s','%s',%d,%d)";
        // INSERT INTO usuarios (nombre,apellido,correo,pass,tel,id_perfil)
        // VALUES ('Bprja','asd','asdasd','asdasd',23,23)
        String queryFormateada = String.format(query, DBSchema.TAB_USER,
                DBSchema.COL_NAME, DBSchema.COL_SNAME, DBSchema.COL_MAIL, DBSchema.COL_PASS, DBSchema.COL_PHO, DBSchema.COL_FK_ID_PROF,
                usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getPass(), usuario.getTelefono(), 1);
        statement.execute(queryFormateada);
    }

    public void insertarUsuarioPS(Usuario usuario) throws SQLException {
        String query = "INSERT INTO %s (%s,%s,%s,%s,%s,%s) " +
                "VALUES (?,?,?,?,?,?)";
        String queryFormateada = String.format(query, DBSchema.TAB_USER,
                DBSchema.COL_NAME, DBSchema.COL_SNAME, DBSchema.COL_MAIL, DBSchema.COL_PASS, DBSchema.COL_PHO, DBSchema.COL_FK_ID_PROF);
        preparedStatement = connection.prepareStatement(queryFormateada);
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getApellido());
        preparedStatement.setString(3, usuario.getCorreo());
        preparedStatement.setString(4, usuario.getPass());
        preparedStatement.setInt(5, usuario.getTelefono());
        preparedStatement.setInt(6, 1);
        preparedStatement.execute();
    }

    public int borrarUsuarioTelefono(int telefono) throws SQLException {
        preparedStatement = connection.prepareStatement(
                String.format("DELETE FROM %s WHERE %s=?", DBSchema.TAB_USER, DBSchema.COL_PHO));
        preparedStatement.setInt(1,telefono);
        return preparedStatement.executeUpdate();
    }

    // SELECT

    public void getUsuarios() throws SQLException {
        // SELECT * FROM USUARIOS
        String query = String.format("SELECT * FROM %s",DBSchema.TAB_USER);
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        //  v (0 a n)
        //  r r r r r r r r r r r
        // r [id,nombre,apellido,correo,pass,tel,id_perfil]
        while (resultSet.next()){
           String nombre = resultSet.getString(DBSchema.COL_NAME);
           String apellido = resultSet.getString(DBSchema.COL_SNAME);
           String correo = resultSet.getString(DBSchema.COL_MAIL);
           int id_perfil = resultSet.getInt(DBSchema.COL_FK_ID_PROF);
           int id = resultSet.getInt(DBSchema.COL_ID);

            System.out.println("ID "+id);
            System.out.println("Nombre "+nombre);
            System.out.println("Apellido "+apellido);
            System.out.println("Correo "+correo);
            System.out.println("id perfil "+id_perfil);
        }


    }
    public Usuario getUsuarioLogin(String pass, String mail){
        // SELECT * FROM usuaris WHERE correo=mail AND password=pass -> Resultset -> recorro -> Usuario

        if(mail.equalsIgnoreCase("coincide")){
            return new Usuario("Borja","Martin","123123","123123",112,2);
        }
        return null;
    }
}
