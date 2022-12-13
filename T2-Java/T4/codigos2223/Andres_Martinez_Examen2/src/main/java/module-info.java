module com.example.andres_martinez_examen2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.andres_martinez_examen2 to javafx.fxml;
    exports com.example.andres_martinez_examen2;
    exports com.example.andres_martinez_examen2.model;
    opens com.example.andres_martinez_examen2.model to javafx.fxml;
}