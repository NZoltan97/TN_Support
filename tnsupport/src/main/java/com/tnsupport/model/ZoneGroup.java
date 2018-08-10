package com.tnsupport.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor
public class ZoneGroup {
	
	@JsonProperty("id")
	private long zoneId;
	
	@JsonProperty("name")
	private String zoneName;
	
	@JsonProperty("zoneGroupType")
	private String zoneGroupType;
}
