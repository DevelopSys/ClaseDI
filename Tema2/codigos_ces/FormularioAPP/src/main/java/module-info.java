module org.example.formularioapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires lombok;

    opens org.example.formularioapp to javafx.fxml;
    exports org.example.formularioapp;
    exports org.example.formularioapp.controller;
    opens org.example.formularioapp.controller to javafx.fxml;

    opens org.example.formularioapp.model to lombok;
    exports org.example.formularioapp.model;
}