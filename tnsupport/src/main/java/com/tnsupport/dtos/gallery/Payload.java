package com.tnsupport.dtos.gallery;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Payload {

	private String template_type;
	private String image_aspect_ratio;
	private ArrayList<Element> elements;
	
	public Payload(String imageRatio) {
		this.template_type = "generic";
		this.image_aspect_ratio = imageRatio;
		elements = new ArrayList<Element>();
				
	}
}
