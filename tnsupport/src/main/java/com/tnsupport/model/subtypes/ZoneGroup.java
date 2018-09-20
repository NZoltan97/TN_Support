package com.tnsupport.model.subtypes;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor
public class ZoneGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	@JsonProperty("id")
	private long zoneGroupId;
	
	@JsonProperty("name")
	private String zoneName;
	
	private String zoneGroupType;
}