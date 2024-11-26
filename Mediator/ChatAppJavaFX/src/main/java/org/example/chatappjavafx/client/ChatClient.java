package org.example.chatappjavafx.client;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.chatappjavafx.mediator.ChatMediator;

public class ChatClient {
    private String username;
    private ChatMediator mediator;

    private TextArea chatArea;
    private TextField messageField;
    private TextField recipientField;

    public ChatClient(String username, ChatMediator mediator, TextArea chatArea, TextField messageField, TextField recipientField) {
        this.username = username;
        this.mediator = mediator;
        this.chatArea = chatArea;
        this.messageField = messageField;
        this.recipientField = recipientField;

        mediator.addClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage() {
        String message = messageField.getText();
        String recipient = recipientField.getText();

        if (message.isEmpty() || recipient.isEmpty()) {
            return;
        }

        mediator.sendMessage(message, username, recipient);
        chatArea.appendText("Me to " + recipient + ": " + message + "\n");
        messageField.clear();
    }

    public void receiveMessage(String message, String sender) {
        Platform.runLater(() -> chatArea.appendText(sender + ": " + message + "\n"));
    }
}
