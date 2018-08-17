package com.tnsupport.controllers.RequestController.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnsupport.controllers.RequestController.IRequestController;
import com.tnsupport.dtos.AttributeDTO;
import com.tnsupport.dtos.ChatFuelDTO;
import com.tnsupport.dtos.InnerDTO;
import com.tnsupport.dtos.gallery.ChatFuelGalleryDTO;
import com.tnsupport.model.Location;
import com.tnsupport.model.Ticket;
import com.tnsupport.services.MainService.impl.MainServiceImpl;
import com.tnsupport.services.RestTemplateService.impl.RestTemplateServiceImpl;

@RestController
public class RequestControllerImpl implements IRequestController {

	@Autowired
	MainServiceImpl mainService;

	@Autowired
	RestTemplateServiceImpl templateService;

	@CrossOrigin
	@RequestMapping(value = "/saveSiteId", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendSiteId(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return mainService.saveSite(innerDto);
	}

	@RequestMapping(value = "/trying", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> tryList() {
		String valami = "{\r\n" + " \"messages\": [\r\n" + "    {\r\n" + "      \"attachment\":{\r\n"
				+ "        \"type\":\"template\",\r\n" + "        \"payload\":{\r\n"
				+ "          \"template_type\":\"generic\",\r\n" + "          \"image_aspect_ratio\": \"square\",\r\n"
				+ "          \"elements\":[\r\n" + "            {\r\n"
				+ "              \"title\":\"Classic White T-Shirt\",\r\n"
				+ "              \"image_url\":\"http://chatbot.synapps.hu/ninja_logo.png\",\r\n"
				+ "              \"subtitle\":\"Soft white cotton t-shirt is back in style\",\r\n"
				+ "              \"buttons\":[\r\n" + "                {\r\n"
				+ "                  \"type\":\"web_url\",\r\n"
				+ "                  \"url\":\"https://petersapparel.parseapp.com/view_item?item_id=100\",\r\n"
				+ "                  \"title\":\"View Item\"\r\n" + "                },\r\n" + "                {\r\n"
				+ "                  \"type\":\"web_url\",\r\n"
				+ "                  \"url\":\"https://petersapparel.parseapp.com/buy_item?item_id=100\",\r\n"
				+ "                  \"title\":\"Buy Item\"\r\n" + "                }\r\n" + "              ]\r\n"
				+ "            },\r\n" + "            {\r\n" + "              \"title\":\"Classic Grey T-Shirt\",\r\n"
				+ "              \"image_url\":\"http://chatbot.synapps.hu/ninja_logo.png\",\r\n"
				+ "              \"subtitle\":\"Soft gray cotton t-shirt is back in style\",\r\n"
				+ "              \"buttons\":[\r\n" + "                {\r\n"
				+ "                  \"type\":\"web_url\",\r\n"
				+ "                  \"url\":\"https://petersapparel.parseapp.com/view_item?item_id=101\",\r\n"
				+ "                  \"title\":\"View Item\"\r\n" + "                },\r\n" + "                {\r\n"
				+ "                  \"type\":\"web_url\",\r\n"
				+ "                  \"url\":\"https://petersapparel.parseapp.com/buy_item?item_id=101\",\r\n"
				+ "                  \"title\":\"Buy Item\"\r\n" + "                }\r\n" + "              ]\r\n"
				+ "            }\r\n" + "          ]\r\n" + "        }\r\n" + "      }\r\n" + "    }\r\n" + "  ]\r\n"
				+ "}";

		return new ResponseEntity<String>(valami, HttpStatus.OK);
	}

	@RequestMapping(value = "/gallery", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ChatFuelGalleryDTO> getGallery() {
		ChatFuelGalleryDTO dto = new ChatFuelGalleryDTO();
		dto.addElement("TicketNinja", "http://chatbot.synapps.hu/background.png", "background",
				 "web_url", "http://chatbot.synapps.hu/ninja_logo.png", "View Item");

		return new ResponseEntity<ChatFuelGalleryDTO>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/siteId", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> getSiteId(@RequestParam("siteId") String siteId) {
		return mainService.getSiteId();
	}

	@RequestMapping(value = "/siteInfo", method = RequestMethod.GET, produces = "application/json")
	public ChatFuelDTO getSiteInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return templateService.getSiteInfo(innerDto);

	}

	@RequestMapping(value = "/performerInfo", method = RequestMethod.GET, produces = "application/json")
	public ChatFuelDTO getPerformerInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return templateService.getPerformers(innerDto);
	}

	@RequestMapping(value = "/zoneInfo", method = RequestMethod.GET, produces = "application/json")
	public ChatFuelDTO getZoneInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return templateService.getZones(innerDto);
	}

	@RequestMapping(value = "/ticketInfo", method = RequestMethod.GET, produces = "application/json")
	public List<Ticket> getTicketInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return templateService.getTickets(innerDto);
	}

	@RequestMapping(value = "/locationInfo", method = RequestMethod.GET, produces = "application/json")
	public List<Location> getLocationInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return templateService.getLocations(innerDto);
	}

	@RequestMapping(value = "/clearCache", method = RequestMethod.GET, produces = "application/json")
	public void clearCache() {
		templateService.resetAllEntries();
	}
}
