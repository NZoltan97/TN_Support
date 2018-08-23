package com.tnsupport.services.RestTemplateService;

import com.tnsupport.dtos.ChatFuelDTO;
import com.tnsupport.dtos.InnerDTO;
import com.tnsupport.dtos.gallery.ChatFuelGalleryDTO;

public interface IRestTemplateService {

	public ChatFuelDTO getSiteInfo(InnerDTO innerDto);

	public ChatFuelGalleryDTO getPerformers(InnerDTO innerDto);

	public ChatFuelGalleryDTO getZones(InnerDTO innerDto);

	public ChatFuelGalleryDTO getTickets(InnerDTO innerDto);

	public ChatFuelGalleryDTO getLocations(InnerDTO innerDto);

}
