module com.example.listas {


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.fxml;
    requires org.json;
    requires json.simple;

    opens com.example.listas to javafx.fxml;
    exports com.example.listas;
}