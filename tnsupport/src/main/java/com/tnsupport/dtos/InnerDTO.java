package com.tnsupport.dtos;

public class InnerDTO {

	private long siteID;
	
	public InnerDTO() {
		
	}
	
	public InnerDTO(long id) {
		this.siteID = id;
	}

	public long getSiteID() {
		return siteID;
	}

	public void setSiteID(long id) {
		this.siteID = id;
	}
	
	
}
