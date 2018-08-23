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
import com.tnsupport.dtos.gallery.Attachment;
import com.tnsupport.dtos.gallery.AttachmentList;
import com.tnsupport.dtos.gallery.ChatFuelGalleryDTO;
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
		ChatFuelDTO dto = new ChatFuelDTO();
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		SiteInfo siteInfo = restTemplate.getForObject(exactURI.toString(), SiteInfo.class);
		dto.addMessages(siteInfo.getSiteName());
		dto.addMessages(siteInfo.getSiteAddress());
		dto.addMessages(siteInfo.getCurrency());
		log.debug("currency:{}", siteInfo.getCurrency());
		return dto;
	}

	@Cacheable("performers")
	public ChatFuelGalleryDTO getPerformers(InnerDTO innerDto) {
		ChatFuelGalleryDTO dto = new ChatFuelGalleryDTO();
		AttachmentList attList = new AttachmentList();
		Attachment attachment = new Attachment();
		attList.setAttachment(attachment);

		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/performers");
		ResponseEntity<List<Performer>> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Performer>>() {
				});
		List<Performer> performers = response.getBody();
		for (Performer performer : performers) {
			dto.addElement(attList, attachment, performer.getName(), performer.getProfilePicBase64(),
					performer.getPosition(), "web_url", performer.getCompanyUrl(), performer.getCompanyName());
		}

		dto.getMessages().add(attList);
		return dto;
	}

//	programok
	@Cacheable("zones")
	public ChatFuelGalleryDTO getZones(InnerDTO innerDto) {
		ChatFuelGalleryDTO dto = new ChatFuelGalleryDTO();
		AttachmentList attList = new AttachmentList();
		Attachment attachment = new Attachment();
		attList.setAttachment(attachment);

		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/zones");
		ResponseEntity<Zone[]> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				Zone[].class);
		Zone[] zones = response.getBody();
		for (Zone zone : zones) {
//			List<ZoneGroup> zoneGroup = zone.getZoneGroups();
//			kell -e ide egyaltalan button??
			dto.addElement(attList, attachment, zone.getName(), "http://chatbot.synapps.hu/tn_chatbot_zones.png",
					zone.getAddress(), "web_url", "url", "buttonTitle");
//			for (ZoneGroup zgroup: zoneGroup) {
//				chatfuelDto.addMessages(zgroup.getZoneGroupType());
//				chatfuelDto.addMessages(Long.toString(zgroup.getZoneId()));
//				chatfuelDto.addMessages(zgroup.getZoneName());
//			}

//			chatfuelDto.addMessages(Boolean.toString(zone.isHighlighted()));
		}

		dto.getMessages().add(attList);
		return dto;
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
		AttachmentList attList = new AttachmentList();
		Attachment attachment = new Attachment();
		attList.setAttachment(attachment);

		for (Ticket ticket : tickets) {
			dto.addElement(attList, attachment, ticket.getName(), "http://chatbot.synapps.hu/tn_chatbot_ticket_pic.png",
					ticket.getDescription(), "web_url", "http://chatbot.synapps.hu/ninja_logo.png"/* Ticket url here */,
					"Megnézem");
		}

		dto.getMessages().add(attList);
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
		AttachmentList attList = new AttachmentList();
		Attachment attachment = new Attachment();
		attList.setAttachment(attachment);

		for (Location location : locations) {
			dto.addElement(attList, attachment, location.getName(), "http://chatbot.synapps.hu/background.png"/**/,
					location.getDescription(), "web_url",
					"http://chatbot.synapps.hu/ninja_logo.png"/* Ticket url here */, "Megnézem");
		}

		dto.getMessages().add(attList);
		return dto;
	}

}
