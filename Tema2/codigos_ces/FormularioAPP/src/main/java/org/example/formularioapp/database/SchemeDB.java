package org.example.formularioapp.database;

public interface SchemeDB {
    // variables -> final static
    // metodos -> sin cuerpo abstractor

    String URL = "127.0.0.1";
    String PORT = "3306";

    String DB_NAME = "formularios";
    String TAB_NAME = "peticiones";
    String COL_ID = "id";
    String COL_NAME = "nombre";
    String COL_MAIL = "mail";
    String COL_LOCATE = "localizacion";
    String COL_GEN = "genero";
    String COL_AG = "edad";

}
