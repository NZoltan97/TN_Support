package com.tnsupport.tnsupport.dtos;

import java.util.ArrayList;

public class ChatFuelDTO {

	private ArrayList<ChatFuelDTOText> messages;
	
	public ChatFuelDTO() {
		messages = new ArrayList<ChatFuelDTOText>();
	}

	public ArrayList<ChatFuelDTOText> getMessages() {
		return messages;
	}

	public void addMessages(String newText) {
		ChatFuelDTOText text=new ChatFuelDTOText(newText);
		this.messages.add(text);
	}

}
