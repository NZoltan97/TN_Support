package com.tnsupport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table (name = "locations")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auto_id")
	private long auto_id;
	
	@JsonProperty("id")
	@Column(name = "locationID")
	private long locationID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "programCount")
	private String programCount;
	
}
