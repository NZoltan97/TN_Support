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
import com.tnsupport.dtos.gallery.ChatFuelGalleryDTO;
import com.tnsupport.model.Location;
import com.tnsupport.model.Performer;
import com.tnsupport.model.SiteInfo;
import com.tnsupport.model.Ticket;
import com.tnsupport.model.Zone;
import com.tnsupport.model.subtypes.ZoneGroup;
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
	public ChatFuelDTO getPerformers(InnerDTO innerDto) {
		ChatFuelDTO chatfuelDto = new ChatFuelDTO();
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/performers");
		ResponseEntity<List<Performer>> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Performer>>() {
				});
		List<Performer> performers = response.getBody();
		for (Performer performer : performers) {
			chatfuelDto.addMessages(performer.getName());
			chatfuelDto.addMessages(performer.getCompanyName());
			chatfuelDto.addMessages(performer.getPosition());
			chatfuelDto.addMessages(performer.getProgramCount());
			chatfuelDto.addMessages(Long.toString(performer.getPerformerID()));
		}

		return chatfuelDto;
	}

	@Cacheable("zones")
	public ChatFuelDTO getZones(InnerDTO innerDto) {
		ChatFuelDTO chatfuelDto = new ChatFuelDTO();
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/zones");
		ResponseEntity<Zone[]> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				Zone[].class);
		Zone[] zones = response.getBody();
		for (Zone zone : zones) {
			List<ZoneGroup> zoneGroup = zone.getZoneGroups();
			chatfuelDto.addMessages(zone.getName());
			chatfuelDto.addMessages(zone.getAddress());
			chatfuelDto.addMessages(zone.getStartDate());
			chatfuelDto.addMessages(zone.getEndDate());
			chatfuelDto.addMessages(Integer.toString(zone.getUpperLimit()));
			chatfuelDto.addMessages(Long.toString(zone.getLocationId()));
			for (ZoneGroup zgroup : zoneGroup) {
				chatfuelDto.addMessages(zgroup.getZoneGroupType());
				chatfuelDto.addMessages(Long.toString(zgroup.getZoneId()));
				chatfuelDto.addMessages(zgroup.getZoneName());
			}
			chatfuelDto.addMessages(Boolean.toString(zone.isHighlighted()));
		}

		return chatfuelDto;
	}

	@CacheEvict(value = "siteInfos", allEntries = true)
	public void resetAllEntries() {
	}

	@Cacheable("tickets")
	public ChatFuelGalleryDTO getTickets(InnerDTO innerDto) {
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/tickets");
		ResponseEntity<List<Ticket>> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Ticket>>() {
				});
		List<Ticket> tickets = response.getBody();
		ChatFuelGalleryDTO dto = new ChatFuelGalleryDTO();
		for (Ticket ticket : tickets) {
			dto.addElement(ticket.getName(), "http://chatbot.synapps.hu/tn_chatbot_ticket_pic.png",
					ticket.getDescription(), "web_url", "http://chatbot.synapps.hu/ninja_logo.png"/* Ticket url here */,
					"Megnézem");
		}
		return dto;
	}

	@Cacheable("locations")
	public ChatFuelGalleryDTO getLocations(InnerDTO innerDto) {
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/tickets");
		ResponseEntity<List<Location>> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Location>>() {
				});
		List<Location> locations = response.getBody();
		ChatFuelGalleryDTO dto = new ChatFuelGalleryDTO();
		for (Location location : locations) {
			dto.addElement(location.getName(), "http://chatbot.synapps.hu/background.png"/**/,
					location.getDescription(), "web_url",
					"http://chatbot.synapps.hu/ninja_logo.png"/* Ticket url here */, "Megnézem");
		}
		return dto;
	}

}