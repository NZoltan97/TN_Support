package com.tnsupport.dtos;

public class AttributeName {
	
	private String siteIDAtt;

	public void setIsCorrect(String siteIDAtt) {
		this.siteIDAtt = siteIDAtt;
	}

	public AttributeName(String siteIDAtt) {
		this.siteIDAtt = siteIDAtt;
	}

	public String getsiteIDAtt() {
		return siteIDAtt;
	}
	
}
