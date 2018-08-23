package com.tnsupport.dtos.gallery;

import lombok.Data;

@Data
public class Attachment {

	private String type;
	private Payload payload;
	
	public Attachment() {
		this.type = "template";
		this.payload = new Payload();
	}
	
}
