package org.example.chatappjavafx.mediator;

import org.example.chatappjavafx.client.ChatClient;

import java.util.HashMap;
import java.util.Map;

public class ChatMediatorImpl implements ChatMediator {

    // Map to store clients with their usernames
    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void sendMessage(String message, String sender, String recipient) {
        if (recipient.equals("All")) {
            // Broadcast the message to all clients
            for (ChatClient client : clients.values()) {
                if (!client.getUsername().equals(sender)) {
                    client.receiveMessage(message, sender);
                }
            }
        } else {
            // Send the message to the specific recipient
            ChatClient recipientClient = clients.get(recipient);
            if (recipientClient != null) {
                recipientClient.receiveMessage(message, sender);
            }
        }
    }

    @Override
    public void addClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }
}
