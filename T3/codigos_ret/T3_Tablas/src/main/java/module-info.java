module com.example.t3_tablas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.json;
    requires com.google.gson;
    requires javafx.media;

    opens com.example.t3_tablas to javafx.fxml;
    exports com.example.t3_tablas;
    exports com.example.t3_tablas.model;
    opens com.example.t3_tablas.model to javafx.fxml, org.json, com.google.gson;
}