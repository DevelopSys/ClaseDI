module org.example.tienda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.tienda to javafx.fxml;
    exports org.example.tienda;
}