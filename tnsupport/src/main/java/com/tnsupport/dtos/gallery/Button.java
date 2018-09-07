package com.tnsupport.dtos.gallery;

import lombok.Data;

@Data
public class Button {

	private String type;
	private String block_names;
	private String title;
	
	public Button(String type, String url, String title) {
		this.type = type;
		this.block_names = url;
		this.title = title;
	}
}
