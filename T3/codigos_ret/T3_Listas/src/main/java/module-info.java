module com.example.t3_listas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.json;
    requires com.google.gson;

    opens com.example.t3_listas to javafx.fxml;
    exports com.example.t3_listas;
    exports com.example.t3_listas.model;
    opens com.example.t3_listas.model to javafx.fxml;
}