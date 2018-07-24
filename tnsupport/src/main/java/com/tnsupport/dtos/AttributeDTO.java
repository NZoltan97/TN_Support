package com.tnsupport.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class AttributeDTO {

	@JsonProperty("set_attributes")
	private AttributeName name;

	public void addAttribute(long value) {
		String stringValue = Long.toString(value);
		this.name = new AttributeName(stringValue);
		
	}

}
