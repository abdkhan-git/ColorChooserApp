module com.example.colorchooserapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.colorchooserapp to javafx.fxml;
    exports com.example.colorchooserapp;
}