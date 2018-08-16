package com.tnsupport.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class InnerDTO {

	private long siteId;
	
	private String siteName;
	
	private String siteAddress;
	
	private String currency;
		
}
