package com.tnsupport.services.RestTemplateService;

import java.util.List;

import com.tnsupport.dtos.ChatFuelDTO;
import com.tnsupport.dtos.InnerDTO;
import com.tnsupport.dtos.gallery.ChatFuelGalleryDTO;
import com.tnsupport.model.Location;
import com.tnsupport.model.Ticket;

public interface IRestTemplateService {

	public ChatFuelDTO getSiteInfo(InnerDTO innerDto);

	public ChatFuelGalleryDTO getPerformers(InnerDTO innerDto);

	public ChatFuelGalleryDTO getZones(InnerDTO innerDto);

	public List<Ticket> getTickets(InnerDTO innerDto);

	public List<Location> getLocations(InnerDTO innerDto);

}
