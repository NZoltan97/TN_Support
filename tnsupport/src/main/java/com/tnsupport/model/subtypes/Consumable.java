package com.tnsupport.model.subtypes;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Consumable implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long consumableId;

	private String name;

	private String description;

	private int maxCount;
	
}
