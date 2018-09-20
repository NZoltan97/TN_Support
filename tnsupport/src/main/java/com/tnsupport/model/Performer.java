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

@Entity @Data @NoArgsConstructor 
public class Performer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long auto_id;
	
	@JsonProperty("id")
	private long performerId;
	
	private String name;

	private String companyName;

	private String position;

	private String programCount;

	private String profilePicBase64;

	private String companyUrl;
	
}
