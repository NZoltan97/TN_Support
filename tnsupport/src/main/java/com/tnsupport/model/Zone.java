package com.tnsupport.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tnsupport.model.subtypes.ZoneGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "zones")
public class Zone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auto_id")
	private long auto_id;

	@JsonProperty("id")
	@Column(name = "zoneID")
	private long zoneID;

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

	@Column(name = "zoneGroups")
	private List<ZoneGroup> zoneGroups;

	@Column(name = "isHighlighted")
	private boolean isHighlighted;
}
