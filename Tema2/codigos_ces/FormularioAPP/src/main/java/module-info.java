module org.example.formularioapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires java.sql;
    requires lombok;
    requires java.desktop;

    opens org.example.formularioapp to javafx.fxml, java.sql;
    exports org.example.formularioapp;
    exports org.example.formularioapp.controller;
    opens org.example.formularioapp.controller to javafx.fxml,java.sql;

    opens org.example.formularioapp.model to lombok,java.sql;
    exports org.example.formularioapp.model;
}