module org.example.demo {
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


    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
    opens org.example.demo.model to javafx.fxml,com.google.gson;
    exports org.example.demo.model;
    opens org.example.demo.dao to javafx.fxml, org.json, com.google.gson;
    exports org.example.demo.dao;

}