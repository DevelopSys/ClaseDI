module org.example.examenpizzeria {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires static lombok;

    opens org.example.examenpizzeria to javafx.fxml;
    exports org.example.examenpizzeria;

    opens org.example.examenpizzeria.controller to javafx.fxml;
    exports org.example.examenpizzeria.controller;

    opens org.example.examenpizzeria.model to javafx.fxml;
    exports org.example.examenpizzeria.model;
}