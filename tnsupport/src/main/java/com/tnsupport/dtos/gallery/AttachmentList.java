package com.tnsupport.dtos.gallery;

import lombok.Data;

@Data
public class AttachmentList {

	private Attachment attachment;
	
	public AttachmentList(String attType) {
		this.attachment = new Attachment(attType);
	}
	
	
}
