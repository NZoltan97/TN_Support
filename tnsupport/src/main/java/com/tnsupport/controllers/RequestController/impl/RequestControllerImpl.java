package com.tnsupport.controllers.RequestController.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tnsupport.controllers.RequestController.IRequestController;
import com.tnsupport.dtos.AttributeDTO;
import com.tnsupport.dtos.InnerDTO;
import com.tnsupport.model.SiteInfo;
import com.tnsupport.services.MainService.impl.MainServiceImpl;
import com.tnsupport.services.RestTemplateService.impl.RestTemplateServiceImpl;

@RestController
public class RequestControllerImpl implements IRequestController {
	
	@Autowired
	MainServiceImpl mainService;
	
	@RequestMapping(value = "/sendSiteID", method = RequestMethod.GET , produces = "application/json")
	public ResponseEntity<AttributeDTO> sendSiteID(@RequestParam ("hostName") String hostName, @RequestParam ("siteIDAtt") String siteIDAtt) {
		InnerDTO innerDto = new InnerDTO();
		innerDto.setSiteID(54321);
		return mainService.saveSite(innerDto);
	}
	
	@RequestMapping(value = "/sendSiteData", method = RequestMethod.GET, produces = "application/json")
	public SiteInfo sendSiteData() {
		RestTemplateServiceImpl restService = new RestTemplateServiceImpl();
		return restService.getSiteInfo();
		
	}
}
