package com.tnsupport.dtos.gallery;


import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName(value = "att")
public class Attachment {

	private String type;
	private Payload payload;
	
	public Attachment() {
		this.type = "template";
		this.payload = new Payload();
	}
	
}
