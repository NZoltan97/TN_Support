package com.tnsupport.model.subtypes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.tnsupport.model.Ticket;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @Entity
public class Property implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long propertyId;
	
	@ManyToOne
	private Ticket ticket;
	
	private String label;
	
}
