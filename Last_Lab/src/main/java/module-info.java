module com.example.last_lab {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.junit.jupiter.api;
    requires java.sql.rowset;

    opens com.example.last_lab to javafx.fxml;
    exports com.example.last_lab;
}