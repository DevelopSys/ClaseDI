module org.example.examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;


    opens org.example.examen to javafx.fxml;
    exports org.example.examen;
    exports org.example.examen.controller;
    opens org.example.examen.controller to javafx.fxml;
    exports org.example.examen.database;
    opens org.example.examen.database to java.sql;
    exports org.example.examen.dao;
    opens org.example.examen.dao to java.sql;
    exports org.example.examen.model;
    opens org.example.examen.model to lombok;
}