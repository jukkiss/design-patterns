module org.example.pixelarteditor {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.pixelarteditor to javafx.fxml;
    exports org.example.pixelarteditor;
}