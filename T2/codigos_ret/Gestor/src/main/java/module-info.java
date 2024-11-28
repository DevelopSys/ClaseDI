module org.example.gestor {
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
    requires org.json;
    requires com.google.gson;
    requires java.sql;
    requires static lombok;

    opens org.example.gestor to javafx.fxml, com.google.gson;
    exports org.example.gestor;
    exports org.example.gestor.model;
    opens org.example.gestor.model to com.google.gson, javafx.fxml, org.json;
    exports org.example.gestor.dao;
    opens org.example.gestor.dao to com.google.gson, javafx.fxml,org.json;
    exports org.example.gestor.controller;
    opens org.example.gestor.controller to com.google.gson, javafx.fxml,org.json;
    exports org.example.gestor.database;
    opens org.example.gestor.database to com.google.gson, javafx.fxml, java.sql;
}