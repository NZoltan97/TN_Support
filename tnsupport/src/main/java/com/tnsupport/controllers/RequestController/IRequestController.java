package com.tnsupport.controllers.RequestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.tnsupport.dtos.AttributeDTO;
import com.tnsupport.dtos.ChatFuelDTO;
import com.tnsupport.dtos.gallery.ChatFuelGalleryDTO;

public interface IRequestController {

	public ResponseEntity<AttributeDTO> sendSiteId(@RequestParam ("siteId") String siteId);
	public ChatFuelDTO getSiteInfo(@RequestParam ("siteId") String siteId);
	public ChatFuelGalleryDTO getPerformerInfo(@RequestParam ("siteId") String siteId);
	public ChatFuelGalleryDTO getZoneInfo(@RequestParam ("siteId") String siteId);
	public ResponseEntity<ChatFuelGalleryDTO> getTicketInfo(@RequestParam ("siteId") String siteId);
	public ResponseEntity<ChatFuelGalleryDTO> getLocationInfo(@RequestParam ("siteId") String siteId);
}
