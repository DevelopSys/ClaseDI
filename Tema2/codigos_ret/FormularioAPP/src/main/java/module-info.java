module org.example.formularioapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens org.example.formularioapp to javafx.fxml;
    exports org.example.formularioapp;
}