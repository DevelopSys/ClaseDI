module org.example.examen1evdi {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires com.google.gson;
    requires java.net.http;


    exports org.example.examen1evdi;
    opens org.example.examen1evdi to javafx.fxml;
    exports org.example.examen1evdi.controller;
    opens org.example.examen1evdi.controller to javafx.fxml, org.json, com.google.gson;
    exports org.example.examen1evdi.model;
    opens org.example.examen1evdi.model to  com.google.gson;
}