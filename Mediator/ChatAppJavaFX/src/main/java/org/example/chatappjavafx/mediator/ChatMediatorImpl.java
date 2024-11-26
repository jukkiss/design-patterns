package org.example.chatappjavafx.mediator;

import org.example.chatappjavafx.client.ChatClient;

import java.util.HashMap;
import java.util.Map;

public class ChatMediatorImpl implements ChatMediator {

    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void sendMessage(String message, String sender, String recipient) {
        if (recipient.equals("All")) {
            for (ChatClient client : clients.values()) {
                if (!client.getUsername().equals(sender)) {
                    client.receiveMessage(message, sender);
                }
            }
        } else {
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
