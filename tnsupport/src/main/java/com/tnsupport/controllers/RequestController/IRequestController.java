package com.tnsupport.controllers.RequestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.tnsupport.dtos.AttributeDTO;
import com.tnsupport.dtos.ChatFuelDTO;
import com.tnsupport.model.Location;
import com.tnsupport.model.Ticket;

public interface IRequestController {

	public ResponseEntity<AttributeDTO> sendSiteId(@RequestParam ("siteId") String siteId);
	public ChatFuelDTO getSiteInfo(@RequestParam ("siteId") String siteId);
	public ChatFuelDTO getPerformerInfo(@RequestParam ("siteId") String siteId);
	public ChatFuelDTO getZoneInfo(@RequestParam ("siteId") String siteId);
	public List<Ticket> getTicketInfo(@RequestParam ("siteId") String siteId);
	public List<Location> getLocationInfo(@RequestParam ("siteId") String siteId);
}
