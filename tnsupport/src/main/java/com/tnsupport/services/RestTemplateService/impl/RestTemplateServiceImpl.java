package com.tnsupport.services.RestTemplateService.impl;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tnsupport.model.Location;
import com.tnsupport.model.Performer;
import com.tnsupport.model.SiteInfo;
import com.tnsupport.model.Ticket;
import com.tnsupport.model.Zone;
import com.tnsupport.services.RestTemplateService.IRestTemplateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestTemplateServiceImpl implements IRestTemplateService {

	final String SITE_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256";
	final String PERFORMER_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256/performers";
	final String ZONE_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256/zones";
	final String TICKET_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256/tickets";
	final String LOCATION_URI = "https://api.sandbox.ticketninja.io/api/v1/landing/115256/locations";

	RestTemplate restTemplate = new RestTemplate();

	@Cacheable("siteInfos")
	public SiteInfo getSiteInfo() {

		SiteInfo siteInfo = restTemplate.getForObject(SITE_URI, SiteInfo.class);

		log.debug("currency:{}", siteInfo.getCurrency());
		return siteInfo;
	};

	@Cacheable("performers")
	public List<Performer> getPerformers() {
		ResponseEntity<List<Performer>> response = restTemplate.exchange(PERFORMER_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Performer>>() {
				});
		List<Performer> performers = response.getBody();
		return performers;
	}

	// @Cacheable("zones")
	public Zone[] getZones() {
		ResponseEntity<Zone[]> response = restTemplate.exchange(ZONE_URI, HttpMethod.GET, null, Zone[].class);
		
		Zone[] zones = response.getBody();
		return zones;
	}

	@CacheEvict(value = "SiteCache", allEntries = true)
	public void resetAllEntries() {
}

	@Cacheable("tickets")
	public List<Ticket> getTickets() {
		ResponseEntity<List<Ticket>> response = restTemplate.exchange(TICKET_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Ticket>>() {
				});
		List<Ticket> tickets = response.getBody();

		return tickets;
	}

	@Cacheable("locations")
	public List<Location> getLocations() {
		ResponseEntity<List<Location>> response = restTemplate.exchange(LOCATION_URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Location>>() {
				});
		List<Location> locations = response.getBody();

		return locations;
	}
}
