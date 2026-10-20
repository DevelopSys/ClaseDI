module org.example.tiendaapp {
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

    opens org.example.tiendaapp to javafx.fxml;
    exports org.example.tiendaapp;
    exports org.example.tiendaapp.controller;
    opens org.example.tiendaapp.controller to javafx.fxml;
    exports org.example.tiendaapp.data;
    opens org.example.tiendaapp.data to javafx.fxml, java.sql;
}