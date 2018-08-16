package com.tnsupport.services.RestTemplateService.impl;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tnsupport.dtos.ChatFuelDTO;
import com.tnsupport.dtos.InnerDTO;
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

	final String URI = "https://api.sandbox.ticketninja.io/api/v1/landing/";

	RestTemplate restTemplate = new RestTemplate();

	@Cacheable("siteInfos")
	public ChatFuelDTO getSiteInfo(InnerDTO innerDto) {
		ChatFuelDTO chatfuelDto = new ChatFuelDTO();
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		SiteInfo siteInfo = restTemplate.getForObject(exactURI.toString(), SiteInfo.class);
		chatfuelDto.addMessages(siteInfo.getSiteName());
		chatfuelDto.addMessages(siteInfo.getSiteAddress());
		chatfuelDto.addMessages(siteInfo.getCurrency());
		log.debug("currency:{}", siteInfo.getCurrency());
		return chatfuelDto;
	}

	@Cacheable("performers")
	public List<Performer> getPerformers(InnerDTO innerDto) {
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/performers");
		ResponseEntity<List<Performer>> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Performer>>() {
				});
		List<Performer> performers = response.getBody();
		return performers;
	}

	@Cacheable("zones")
	public Zone[] getZones(InnerDTO innerDto) {
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/zones");
		ResponseEntity<Zone[]> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				Zone[].class);
		Zone[] zones = response.getBody();
		return zones;
	}

	@CacheEvict(value = "SiteCache", allEntries = true)
	public void resetAllEntries() {
	}

	@Cacheable("tickets")
	public List<Ticket> getTickets(InnerDTO innerDto) {
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/tickets");
		ResponseEntity<List<Ticket>> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Ticket>>() {
				});
		List<Ticket> tickets = response.getBody();

		return tickets;
	}

	@Cacheable("locations")
	public List<Location> getLocations(InnerDTO innerDto) {
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/tickets");
		ResponseEntity<List<Location>> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Location>>() {
				});
		List<Location> locations = response.getBody();

		return locations;
	}
}
