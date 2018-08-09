package com.tnsupport.controllers.RequestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.tnsupport.dtos.AttributeDTO;
import com.tnsupport.model.Performer;
import com.tnsupport.model.SiteInfo;

public interface IRequestController {

	public ResponseEntity<AttributeDTO> sendSiteID(@RequestParam ("hostName") String hostName, @RequestParam ("siteIDAtt") String siteIDAtt);
	
	public SiteInfo sendSiteInfo();
	
	public List<Performer> sendPerformerInfo();
}
