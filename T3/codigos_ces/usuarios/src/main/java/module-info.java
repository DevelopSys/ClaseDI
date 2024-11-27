module org.example.usuarios {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires org.json;
    requires com.google.gson;

    opens org.example.usuarios to javafx.fxml;
    exports org.example.usuarios;

    exports org.example.usuarios.database;
    opens org.example.usuarios.database to javafx.fxml, java.sql;

    exports org.example.usuarios.model;
    opens org.example.usuarios.model to javafx.fxml, org.json, com.google.gson;

    exports org.example.usuarios.dao;
    opens org.example.usuarios.dao to javafx.fxml, java.sql;

    exports org.example.usuarios.controller;
    opens org.example.usuarios.controller to javafx.fxml, java.sql;
}