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
@Table (name = "performers")
public class Performer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auto_id")
	private long auto_id;
	
	@JsonProperty("id")
	@Column(name = "performerID")
	private long performerID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "programCount")
	private String programCount;
	
}
