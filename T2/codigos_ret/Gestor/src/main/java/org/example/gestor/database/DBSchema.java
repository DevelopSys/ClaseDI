package org.example.gestor.database;

public interface DBSchema {

    String HOST ="localhost";
    String PORT ="3306";
    String DB_NAME = "gestor_ret";
    String TAB_USER = "usuarios";
    String COL_ID = "id";
    String COL_NAME = "nombre";
    String COL_SNAME = "apellido";
    String COL_MAIL = "correo";
    String COL_PHO= "telefono";
    String COL_PASS ="contrasenia";
    String COL_FK_ID_PROF = "id_perfil";

}
