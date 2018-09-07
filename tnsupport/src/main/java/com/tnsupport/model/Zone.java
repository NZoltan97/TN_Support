package com.tnsupport.model;

import java.io.Serializable;

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
@Data
@NoArgsConstructor
@Table(name = "zones")
public class Zone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auto_id")
	private long auto_id;

	@JsonProperty("id")
	@Column(name = "zoneId")
	private long zoneId;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "startDate")
	private String startDate;

	@Column(name = "endDate")
	private String endDate;

	@Column(name = "upperLimit")
	private int upperLimit;

	@Column(name = "locationId")
	private long locationId;

//	@Column(name = "zoneGroups")
//	private List<ZoneGroup> zoneGroups;

	@Column(name = "isHighlighted")
	private boolean isHighlighted;
	
	@Column(name = "isLiked")
	private boolean isLiked;
}
