package com.tnsupport.model.subtypes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Consumable {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private int maxCount;
	
}
