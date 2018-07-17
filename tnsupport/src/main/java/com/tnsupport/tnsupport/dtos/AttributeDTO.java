package com.tnsupport.tnsupport.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeDTO {

	@JsonProperty("set_attributes")
	private AttributeName name;
	

	public AttributeDTO() {
		
	}
	
	public void setName(AttributeName name) {
		this.name=name;
	}
	
	
	public AttributeName getName() {
		return name;
	}

	public void addAttribute(long value) {
		String stringValue = Long.toString(value);
		this.name = new AttributeName(stringValue);
		
	}

}
