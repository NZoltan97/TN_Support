package com.tnsupport.dtos.gallery;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ChatFuelGalleryDTO {

	private ArrayList<AttachmentList> messages;
	
	public ChatFuelGalleryDTO() {
		messages =  new ArrayList<AttachmentList>();
	}
	
	public void addElement(String elementTitle, String elementImage_url, String elementSubtitle,
		String buttonType, String buttonUrl, String buttonTitle) {
		AttachmentList attList = new AttachmentList();
		Attachment attachment = new Attachment();
		attList.setAttachment(attachment);
		Element element = new Element(elementTitle, elementImage_url, elementSubtitle);
		Button button = new Button(buttonType, buttonUrl, buttonTitle);
		element.addButton(button);
		attachment.getPayload().getElements().add(element);
		messages.add(attList);
	}
	
}
