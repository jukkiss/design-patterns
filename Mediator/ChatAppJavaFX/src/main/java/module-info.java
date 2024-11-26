module org.example.chatappjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.chatappjavafx to javafx.fxml;
    exports org.example.chatappjavafx;
}