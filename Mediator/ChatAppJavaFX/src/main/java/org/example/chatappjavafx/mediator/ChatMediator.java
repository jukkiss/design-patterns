package org.example.chatappjavafx.mediator;

import org.example.chatappjavafx.client.ChatClient;

public interface ChatMediator {
    void sendMessage(String message, String sender, String recipient);
    void addClient(ChatClient client);
}