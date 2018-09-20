package com.tnsupport.controllers.RequestController.impl;

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
import com.tnsupport.repository.MainDAO.impl.MainDAOImpl;
import com.tnsupport.services.RestTemplateService.impl.RestTemplateServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RequestControllerImpl implements IRequestController {

	@Autowired
	MainDAOImpl mainDao;

	@Autowired
	RestTemplateServiceImpl templateService;

	@CrossOrigin
	@RequestMapping(value = "/saveSiteId", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendSiteId(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return mainDao.saveSite(innerDto);
	}

	@RequestMapping(value = "/valami", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> getSuck(@RequestParam("siteId") String siteId) {
		AttributeDTO attDto = new AttributeDTO();
		attDto.addAttribute(1);
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/siteId", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> getSiteId(@RequestParam("siteId") String siteId) {
		return mainDao.getSiteId();
	}

	@RequestMapping(value = "/siteInfo", method = RequestMethod.GET, produces = "application/json")
	public ChatFuelDTO getSiteInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return templateService.getSiteInfo(innerDto);
	}

	@RequestMapping(value = "/performerInfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ChatFuelGalleryDTO> getPerformerInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		log.info("RestController siteId=", innerDto.getSiteId());
		return new ResponseEntity<ChatFuelGalleryDTO>(templateService.getPerformers(innerDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/zoneInfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ChatFuelGalleryDTO> getZoneInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return new ResponseEntity<ChatFuelGalleryDTO>(templateService.getZones(innerDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/ticketInfo", method = RequestMethod.GET, produces = "application/json")
	public /*ResponseEntity<ChatFuelGalleryDTO>*/ void getTicketInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
//		return new ResponseEntity<ChatFuelGalleryDTO>(templateService.getTickets(innerDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/locationInfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ChatFuelGalleryDTO> getLocationInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return new ResponseEntity<ChatFuelGalleryDTO>(templateService.getLocations(innerDto), HttpStatus.OK);
	}

//	@RequestMapping(value = "/like", method = RequestMethod.GET, produces = "application/json")
//	public ResponseEntity<AttributeDTO> setLikedZone() {
//		mainService.setLikedZone();
//		return new ResponseEntity<ChatFuelGalleryDTO>(,HttpStatus.OK);
//	}
	
	@RequestMapping(value = "/likedZones", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ChatFuelGalleryDTO> getLikedZones() {
		return new ResponseEntity<ChatFuelGalleryDTO>(mainDao.getLikedZones(),HttpStatus.OK);
	}

	@RequestMapping(value = "/clearCache", method = RequestMethod.GET, produces = "application/json")
	public void clearCache() {
		templateService.resetAllEntries();
	}
}
