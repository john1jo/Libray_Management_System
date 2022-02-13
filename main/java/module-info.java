/**
 *
 */
module com.example.librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires java.sql;

    opens com.example.librarymanagementsystem to javafx.fxml;
    exports com.example.librarymanagementsystem;
}