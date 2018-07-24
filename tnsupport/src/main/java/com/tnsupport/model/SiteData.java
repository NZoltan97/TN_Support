package com.tnsupport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@Table(name = "siteInfo")
public class SiteData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auto_id")
	private long auto_id;
	
	@Column(name = "siteID")
	private long id;
	
	@Column(name = "siteName")
	private String siteName;
	
	@Column(name = "siteAddress")
	private String siteAddress;
	
	@Column(name = "currency")
	private String currency;
}
