package com.tnsupport.services.RestTemplateService.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tnsupport.model.SiteInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestTemplateServiceImpl {
	
	final String ROOT_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256";
	
	public SiteInfo getSiteInfo() {
		
		RestTemplate restTemplate = new RestTemplate();
		SiteInfo siteInfo = restTemplate.getForObject(ROOT_URI, SiteInfo.class);
		
		log.debug("currency:{}",siteInfo.getCurrency());
		return siteInfo;
		
	}
}
