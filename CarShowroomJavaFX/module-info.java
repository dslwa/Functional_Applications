module JavaFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    opens Core to javafx.base;
    opens controllers to javafx.fxml, javafx.graphics;
}