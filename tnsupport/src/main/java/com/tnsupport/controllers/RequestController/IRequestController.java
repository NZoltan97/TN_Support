package com.tnsupport.controllers.RequestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.tnsupport.dtos.AttributeDTO;
import com.tnsupport.dtos.ChatFuelDTO;
import com.tnsupport.model.Location;
import com.tnsupport.model.Performer;
import com.tnsupport.model.Ticket;
import com.tnsupport.model.Zone;

public interface IRequestController {

	public ResponseEntity<AttributeDTO> sendSiteId(@RequestParam ("siteId") String siteId);
	public ChatFuelDTO getSiteInfo(@RequestParam ("siteId") String siteId);
	public List<Performer> getPerformerInfo(@RequestParam ("siteId") String siteId);
	public Zone[] getZoneInfo(@RequestParam ("siteId") String siteId);
	public List<Ticket> getTicketInfo(@RequestParam ("siteId") String siteId);
	public List<Location> getLocationInfo(@RequestParam ("siteId") String siteId);
}
