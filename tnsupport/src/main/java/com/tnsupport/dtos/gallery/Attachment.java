package com.tnsupport.dtos.gallery;
import lombok.Data;

@Data
public class Attachment {

	private String type;
	private Payload payload;
	
	public Attachment(String imageRatio) {
		this.type = "template";
		this.payload = new Payload(imageRatio);
	}
	
}
