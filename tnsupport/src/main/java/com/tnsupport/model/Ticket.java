package com.tnsupport.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tnsupport.model.subtypes.Consumable;
import com.tnsupport.model.subtypes.Property;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auto_id")
	private long auto_id;

	@JsonProperty("id")
	@Column(name = "ticketID")
	private long ticketID;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private String price;

	@Column(name = "currency")
	private String currency;

	@Column(name = "expired")
	private String expired;

	@Column(name = "properties")
	private List<Property> properties;
	
	@Column(name = "zones")
	private List<Zone> zones;
	
	@Column(name = "consumables")
	private List<Consumable> consumables;
}
