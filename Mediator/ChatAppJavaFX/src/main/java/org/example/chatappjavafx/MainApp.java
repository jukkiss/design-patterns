package org.example.chatappjavafx;

import org.example.chatappjavafx.client.ChatClient;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.chatappjavafx.mediator.ChatMediator;
import org.example.chatappjavafx.mediator.ChatMediatorImpl;

public class MainApp extends Application {

    private ChatMediator chatMediator;

    @Override
    public void start(Stage primaryStage) {
        chatMediator = new ChatMediatorImpl();

        createClientWindow("User1");
        createClientWindow("User2");
        createClientWindow("User3");
    }

    private void createClientWindow(String username) {
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setPrefHeight(300);

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message here");

        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient (type 'All' for broadcast)");

        Button sendButton = new Button("Send");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(new Label("Chat for " + username), chatArea, recipientField, messageField, sendButton);

        ChatClient client = new ChatClient(username, chatMediator, chatArea, messageField, recipientField);

        sendButton.setOnAction(e -> client.sendMessage());

        Stage clientStage = new Stage();
        clientStage.setTitle(username);
        clientStage.setScene(new Scene(layout, 400, 400));
        clientStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}