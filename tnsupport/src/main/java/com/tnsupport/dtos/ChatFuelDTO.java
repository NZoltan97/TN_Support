package com.tnsupport.dtos;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ChatFuelDTO {

	private ArrayList<ChatFuelDTOText> messages;
	
	public ChatFuelDTO() {
		messages = new ArrayList<ChatFuelDTOText>();
	}

	public void addMessages(String newText) {
		ChatFuelDTOText text = new ChatFuelDTOText(newText);
		this.messages.add(text);
	}

}
