module org.example.javafxrenderingrpgflyweight {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxrenderingrpgflyweight to javafx.fxml;
    exports org.example.javafxrenderingrpgflyweight;
}