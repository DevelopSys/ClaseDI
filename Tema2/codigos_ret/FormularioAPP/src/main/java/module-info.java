module org.example.formularioapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires lombok;

    opens org.example.formularioapp to javafx.fxml, lombok;
    exports org.example.formularioapp;
}