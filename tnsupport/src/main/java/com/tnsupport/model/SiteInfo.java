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
@Data @NoArgsConstructor
@Table(name = "sites")
public class SiteInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auto_id")
	private long auto_id;

	@JsonProperty("id")
	@Column(name = "siteId")
	private long siteId;
	
	@Column(name = "siteName")
	private String siteName;
	
	@Column(name = "siteAddress")
	private String siteAddress;
	
	@Column(name = "currency")
	private String currency;
	
}
