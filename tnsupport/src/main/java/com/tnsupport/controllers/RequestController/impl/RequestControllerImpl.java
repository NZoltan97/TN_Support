package com.tnsupport.controllers.RequestController.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnsupport.controllers.RequestController.IRequestController;
import com.tnsupport.dtos.AttributeDTO;
import com.tnsupport.dtos.InnerDTO;
import com.tnsupport.model.Location;
import com.tnsupport.model.Performer;
import com.tnsupport.model.SiteInfo;
import com.tnsupport.model.Ticket;
import com.tnsupport.model.Zone;
import com.tnsupport.services.MainService.impl.MainServiceImpl;
import com.tnsupport.services.RestTemplateService.impl.RestTemplateServiceImpl;

@RestController
public class RequestControllerImpl implements IRequestController {

	@Autowired
	MainServiceImpl mainService;

	@Autowired
	RestTemplateServiceImpl templateService;

	@CrossOrigin
	@RequestMapping(value = "/siteId", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<AttributeDTO> sendSiteId(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return mainService.saveSite(innerDto);
	}

	@RequestMapping(value = "/siteInfo", method = RequestMethod.GET, produces = "application/json")
	public SiteInfo getSiteInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return templateService.getSiteInfo(innerDto);

	}

	@RequestMapping(value = "/performerInfo", method = RequestMethod.GET, produces = "application/json")
	public List<Performer> getPerformerInfo(@RequestParam("siteId") String siteId) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteId(Long.parseLong(siteId));
		return templateService.getPerformers(innerDto);
	}

	@RequestMapping(value = "/zoneInfo", method = RequestMethod.GET, produces = "application/json")
	public Zone[] getZoneInfo(@RequestParam("siteId") String siteId) {
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
