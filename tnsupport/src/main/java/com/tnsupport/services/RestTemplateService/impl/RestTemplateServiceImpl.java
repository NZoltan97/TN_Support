package com.tnsupport.services.RestTemplateService.impl;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tnsupport.model.Performer;
import com.tnsupport.model.SiteInfo;
import com.tnsupport.model.Zone;
import com.tnsupport.services.RestTemplateService.IRestTemplateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestTemplateServiceImpl implements IRestTemplateService {

	final String SITE_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256";
	final String PERFORMER_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256/performers";
	final String ZONE_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256/zones";
	
	RestTemplate restTemplate = new RestTemplate();

	public SiteInfo getSiteInfo() {

		SiteInfo siteInfo = restTemplate.getForObject(SITE_URI, SiteInfo.class);

		log.debug("currency:{}", siteInfo.getCurrency());
		return siteInfo;
	};

//	public Performer[] getPerformers() {
//		ResponseEntity<Performer[]> responseEntity = restTemplate.getForEntity(PERFORMER_URI, Performer[].class);
//		Performer[] performers = responseEntity.getBody();
//		
//		return performers;	
//	}

	@Cacheable("SiteCache")
	public List<Performer> getPerformers() {
		ResponseEntity<List<Performer>> response = restTemplate.exchange(PERFORMER_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Performer>>() {
				});
		List<Performer> performers = response.getBody();

		return performers;
	}
	
	public Zone[] getZones() {
		ResponseEntity<Zone[]> response = restTemplate.exchange(ZONE_URI, HttpMethod.GET, null, Zone[].class);
		
		Zone[] zone = response.getBody();
		return zone;
	}

	@CacheEvict(value = "SiteCache", allEntries = true)
	public void resetAllEntries() {
	}
}
