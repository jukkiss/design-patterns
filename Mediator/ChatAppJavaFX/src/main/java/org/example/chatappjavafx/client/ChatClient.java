package org.example.chatappjavafx.client;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.chatappjavafx.mediator.ChatMediator;

public class ChatClient {
    private String username;
    private ChatMediator mediator;

    private TextArea chatArea; // For displaying messages
    private TextField messageField; // For entering messages
    private TextField recipientField; // For selecting a recipient

    public ChatClient(String username, ChatMediator mediator, TextArea chatArea, TextField messageField, TextField recipientField) {
        this.username = username;
        this.mediator = mediator;
        this.chatArea = chatArea;
        this.messageField = messageField;
        this.recipientField = recipientField;

        // Register this client with the mediator
        mediator.addClient(this);
    }

    public String getUsername() {
        return username;
    }

    // Send a message via the mediator
    public void sendMessage() {
        String message = messageField.getText();
        String recipient = recipientField.getText();

        if (message.isEmpty() || recipient.isEmpty()) {
            return; // Avoid sending empty messages
        }

        mediator.sendMessage(message, username, recipient);
        chatArea.appendText("Me to " + recipient + ": " + message + "\n");
        messageField.clear();
    }

    // Receive a message from the mediator
    public void receiveMessage(String message, String sender) {
        Platform.runLater(() -> chatArea.appendText(sender + ": " + message + "\n"));
    }
}
