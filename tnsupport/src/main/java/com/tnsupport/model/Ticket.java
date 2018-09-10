package com.tnsupport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tnsupport.model.subtypes.Consumable;
import com.tnsupport.model.subtypes.Property;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auto_id")
	private long auto_id;
	
	@Id
	@JsonProperty("id")
	private long ticketId;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private String price;

	@Column(name = "currency")
	private String currency;

	@Column(name = "expired")
	private String expired;
	
	@Column(name = "description")
	private String description;

//	@Column(name = "properties")
//	private List<Property> properties;
//	
//	@ElementCollection
//	@CollectionTable(
//			name = "zonesList",
//			joinColumns=@JoinColumn(name ="id", referencedColumnName="id")
//			)
//	@Column(name = "zones")
//	private List<Zone> zones= new ArrayList<Zone>();
//	
//	@ElementCollection
//	@CollectionTable(
//			name = "consumablesList",
//			joinColumns=@JoinColumn(name ="id", referencedColumnName="id")
//			)
//	@Column(name = "consumables")
//	private List<Consumable> consumables = new ArrayList<Consumable>();
}
