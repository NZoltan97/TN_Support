package com.tnsupport.model.subtypes;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor
public class ZoneGroup {
	
	@JsonProperty("id")
	private long zoneId;
	
	@JsonProperty("name")
	private String zoneName;
	
	private String zoneGroupType;
}