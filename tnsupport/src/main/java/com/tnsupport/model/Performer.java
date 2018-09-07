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
@Table (name = "performers")
public class Performer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auto_id")
	private long auto_id;
	
	@JsonProperty("id")
	@Column(name = "performerId")
	private long performerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "programCount")
	private String programCount;
	
	@Column(name = "profilePicBase64")
	private String profilePicBase64;
	
	@Column(name = "companyUrl")
	private String companyUrl;
	
}
