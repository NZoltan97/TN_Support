package com.tnsupport.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data @Entity @NoArgsConstructor
public class Zone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("id")
	private long zoneId;


	private String name;


	private String address;


	private String startDate;


	private String endDate;


	private int upperLimit;
	
//	@Embedded
//	@ElementCollection
//	@JoinTable(name="Zones_Locations")
//	private List<Location> locations = new ArrayList<Location>();
//	
//	private void addLocation(Location location) {
//		this.locations.add(location);
//	}
//	
//	@Embedded
//	@ElementCollection
//	@JoinTable(name="Zones_ZoneGroups")
//	private List<ZoneGroup> zoneGroups= new ArrayList<ZoneGroup>();
//
//	private void addZoneGroup(ZoneGroup zoneGroup) {
//		this.zoneGroups.add(zoneGroup);
//	}

	private boolean isHighlighted;
	

	private boolean isLiked;
}
