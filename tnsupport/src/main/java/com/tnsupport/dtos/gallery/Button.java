package com.tnsupport.dtos.gallery;

import lombok.Data;

@Data
public class Button {

	private String type;
	private String block_name;
	private String title;
	
	public Button(String type, String url, String title) {
		this.type = type;
		this.block_name = url;
		this.title = title;
	}
}
