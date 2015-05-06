package com.lelyak.service;

import com.lelyak.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
    private List<Message> allMessagesList;

    public MessageService() {
        allMessagesList = new ArrayList<>();
        // hard coded DB mock
        Message m1 = new Message(1L, "Hello World", "Lelyak");
        Message m2 = new Message(2L, "Hello Jersey", "Lelyak");
        allMessagesList.add(m1);
        allMessagesList.add(m2);
    }

    public List<Message> getAllMessages() {
        return allMessagesList;
    }

    public Message getMessage(long messageId) {
        for (Message message : allMessagesList) {
            if (message.getId() == messageId) {
                return message;
            }
        }
        return null;
    }

    public Message addMessage(Message message) {
        allMessagesList.add(message);
        return message;
    }

    public Message updateMessage(Message message) {
        return null;
    }

    public void removeMessage(long id) {
        for (int i = 0; i < allMessagesList.size(); i++) {
            long currentId = allMessagesList.get(i).getId();
            if (currentId == id) {
                allMessagesList.remove(i);
            }
        }
    }
}