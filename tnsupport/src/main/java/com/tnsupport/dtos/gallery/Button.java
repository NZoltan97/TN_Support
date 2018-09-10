package com.tnsupport.dtos.gallery;

import lombok.Data;

@Data
public class Button {

	private String type;
	private String url;
	private String title;
	
	public Button(String type, String url, String title) {
		this.type = type;
		this.url = url;
		this.title = title;
	}
}
