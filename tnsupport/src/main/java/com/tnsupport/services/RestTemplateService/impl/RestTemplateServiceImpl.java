package com.tnsupport.services.RestTemplateService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tnsupport.dtos.ChatFuelDTO;
import com.tnsupport.dtos.InnerDTO;
import com.tnsupport.dtos.gallery.AttachmentList;
import com.tnsupport.dtos.gallery.ChatFuelGalleryDTO;
import com.tnsupport.model.Location;
import com.tnsupport.model.Performer;
import com.tnsupport.model.SiteInfo;
import com.tnsupport.model.Ticket;
import com.tnsupport.model.Zone;
import com.tnsupport.repository.IZoneDAO;
import com.tnsupport.repository.MainDAO.impl.MainDAOImpl;
import com.tnsupport.services.RestTemplateService.IRestTemplateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestTemplateServiceImpl implements IRestTemplateService {

	final String URI = "https://api.ticketninja.io/api/v1/landing/";
	@Autowired
	public MainDAOImpl mainDao;
	
	@Autowired
	public IZoneDAO zoneDao;

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
		innerDto.setVisitedId(1);
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/performers");
		log.info("RestTemplateServiceImpl URI = ", exactURI.toString());
		ResponseEntity<List<Performer>> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Performer>>() {
				});
		List<Performer> performers = response.getBody();
		ChatFuelGalleryDTO dto = new ChatFuelGalleryDTO();
		AttachmentList attList = new AttachmentList("square");

		for (int i = (mainDao.getVisitedCount(innerDto)); i < performers.size(); i++) {
			dto.addElement(attList, performers.get(i).getName(), performers.get(i).getProfilePicBase64(),
					performers.get(i).getPosition(), "web_url", performers.get(i).getCompanyUrl(),
					performers.get(i).getCompanyName());
			if ((i+1) % 5 == 0) {
				innerDto.setVisitedPerfCount(i + 1);
				mainDao.setVisitedCount(innerDto);
				break;
			}
		}

		// int i=0;
		// for (Performer performer : performers) {
		// dto.addElement(attList, attachment, performer.getName(),
		// performer.getProfilePicBase64(),
		// performer.getPosition(), "web_url", performer.getCompanyUrl(),
		// performer.getCompanyName());
		// i++;
		// if(i==4) {
		// break;
		// }
		// }

		dto.getMessages().add(attList);
		return dto;
	}

	// programok
	@Cacheable("zones")
	public ChatFuelGalleryDTO getZones(InnerDTO innerDto) {
		innerDto.setVisitedId(2);
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/zones");
		ResponseEntity<Zone[]> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				Zone[].class);
		Zone[] zones = response.getBody();
		for(int i=0; i<zones.length;i++) {
			zoneDao.save(zones[i]);
		}
		//Mainservice
		ChatFuelGalleryDTO dto = new ChatFuelGalleryDTO();
		AttachmentList attList = new AttachmentList("horizontal");

		for (int i = mainDao.getVisitedCount(innerDto); i < zones.length; i++) {
			dto.addElement(attList, zones[i].getName(), "http://chatbot.synapps.hu/tn_chatbot_zones.png",
					zones[i].getAddress(), "web_url",
					"https://ideathon.ticketninja.io/sessions/" + zones[i].getZoneId(), "Megnézem");
			zoneDao.save(zones[i]);
			if (i % 5 == 0) {
				innerDto.setVisitedZoneCount(i + 1);
				mainDao.setVisitedCount(innerDto);
				break;
			}
		}
		// for (Zone zone : zones) {
		// dto.addElement(attList, attachment, zone.getName(),
		// "http://chatbot.synapps.hu/tn_chatbot_zones.png",
		// zone.getAddress(), "web_url", "https://ideathon.ticketninja.io/sessions/" +
		// zone.getZoneID(),
		// "Megnézem");
		// }

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
		AttachmentList attList = new AttachmentList("horizontal");

		for (int i = mainDao.getVisitedCount(innerDto); i < tickets.size(); i++) {
			dto.addElement(attList, tickets.get(i).getName(),
					"http://chatbot.synapps.hu/tn_chatbot_ticket_pic.png", tickets.get(i).getDescription(), "web_url",
					"https://ideathon.ticketninja.io/#tickets", "Megnézem");
			if (i % 5 == 0) {
				innerDto.setVisitedTicketCount(i + 1);
				mainDao.setVisitedCount(innerDto);
				break;
			}
		}

		// for (Ticket ticket : tickets) {
		//
		// dto.addElement(attList, attachment, ticket.getName(),
		// "http://chatbot.synapps.hu/tn_chatbot_ticket_pic.png",
		// ticket.getDescription(), "web_url",
		// "https://ideathon.ticketninja.io/#tickets", "Megnézem");
		// }

		dto.getMessages().add(attList);
		return dto;
	}

	@Cacheable("locations")
	public ChatFuelGalleryDTO getLocations(InnerDTO innerDto) {
		StringBuilder exactURI = new StringBuilder();
		exactURI.append(URI);
		exactURI.append(innerDto.getSiteId());
		exactURI.append("/locations");
		ResponseEntity<List<Location>> response = restTemplate.exchange(exactURI.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Location>>() {
				});
		List<Location> locations = response.getBody();
		ChatFuelGalleryDTO dto = new ChatFuelGalleryDTO();
		AttachmentList attList = new AttachmentList("horizontal");

		for (int i = mainDao.getVisitedCount(innerDto); i < locations.size(); i++) {
			dto.addElement(attList, locations.get(i).getName(), "http://chatbot.synapps.hu/ninja_logo.png",

					locations.get(i).getDescription(), "web_url",
					"https://www.google.hu/maps/dir//" + locations.get(i).getName().replace(" ", "+"),
					"Útvonaltervezés");
			if (i % 5 == 0) {
				innerDto.setVisitedLocationCount(i + 1);
				mainDao.setVisitedCount(innerDto);
				break;
			}
		}
		// for (Location location : locations) {
		// dto.addElement(attList, attachment, location.getName(),
		// "http://chatbot.synapps.hu/ninja_logo.png",
		// location.getDescription(), "web_url",
		// "https://www.google.hu/maps/dir//" + location.getName().replace(" ", "+"),
		// "Útvonaltervezés");
		// }

		dto.getMessages().add(attList);
		return dto;
	}

}
