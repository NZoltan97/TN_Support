package com.tnsupport.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tnsupport.model.subtypes.Property;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonProperty("id")
	private long ticketId;

	private String name;

	private String price;

	private String currency;

	private String expired;

	private String description;
	
	@OneToMany(mappedBy="ticket")
	private List<Property> property = new ArrayList<Property>();
		
//	@Embedded
//	@ElementCollection
//	@JoinTable(name="Tickets_Zones")
//	private List<Zone> zones = new ArrayList<Zone>();
	
//	@Embedded
//	@ElementCollection
//	@JoinTable(name="Tickets_Consumables")
//	private List<Consumable> consumables = new ArrayList<Consumable>();
//	
//	private void addConsums(Consumable consumables) {
//		this.consumables.add(consumables);
//	}
}
