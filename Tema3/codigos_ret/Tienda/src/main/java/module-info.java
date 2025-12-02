module org.example.tienda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;


    opens org.example.tienda.dao to java.sql;
    exports org.example.tienda.dao;
    opens org.example.tienda.model to lombok;
    exports org.example.tienda.model;
    opens org.example.tienda to javafx.fxml;
    exports org.example.tienda;
    exports org.example.tienda.controller;
    opens org.example.tienda.controller to javafx.fxml;
}