package com.tnsupport.dtos;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ChatFuelDTO {

	private ArrayList<ChatFuelDTOText> messages;

	public void addMessages(String newText) {
		ChatFuelDTOText text=new ChatFuelDTOText(newText);
		this.messages.add(text);
	}

}
