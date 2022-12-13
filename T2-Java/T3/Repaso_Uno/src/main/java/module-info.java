module com.example.repaso_uno {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    //requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
   //requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.repaso_uno to javafx.fxml;
    exports com.example.repaso_uno;
}