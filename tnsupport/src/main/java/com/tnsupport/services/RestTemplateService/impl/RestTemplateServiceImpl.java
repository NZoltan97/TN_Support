package com.tnsupport.services.RestTemplateService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tnsupport.model.SiteData;

public class RestTemplateServiceImpl {

	@Autowired
	RestTemplate restTemplate;
	
	final String ROOT_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256";
	
	public ResponseEntity<SiteData> getSiteData() {
		
		ResponseEntity<SiteData> response = restTemplate.getForEntity(ROOT_URI, SiteData.class);
		return response;
		
	}
}
