package com.tnsupport.dtos.gallery;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Element {

	private String title;
	private String image_url;
	private String subtitle;
	private ArrayList<Button> buttons;
	
	public Element(String title, String image_url, String subtitle) {
		this.title = title;
		this.image_url = image_url;
		this.subtitle = subtitle;
		buttons = new ArrayList<Button>();
	}
	
	public void addButton (Button button) {
		buttons.add(button);
	}
}
