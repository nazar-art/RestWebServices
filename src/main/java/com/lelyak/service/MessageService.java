package com.lelyak.service;

import com.lelyak.database.DatabaseClass;
import com.lelyak.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {

    private Map<Long, Message> allMessages = DatabaseClass.getMessages();

    public MessageService() {
        // hard coded DB mock
        Message m1 = new Message(1L, "Hello World", "Lelyak");
        Message m2 = new Message(2L, "Hello Jersey", "Lelyak");
        allMessages.put(1L, m1);
        allMessages.put(2L, m2);
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(allMessages.values());
    }

    public Message getMessage(long messageId) {
        return allMessages.get(messageId);
    }

    public Message addMessage(Message message) {
        message.setId(allMessages.size() + 1);
        allMessages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() < 0) {
            return null;
        }
        return allMessages.put(message.getId(), message);
    }

    public Message removeMessage(long id) {
        return allMessages.remove(id);
    }
}