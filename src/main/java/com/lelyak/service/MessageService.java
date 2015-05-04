package com.lelyak.service;

import java.util.ArrayList;
import java.util.List;

import com.lelyak.model.Message;

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
}