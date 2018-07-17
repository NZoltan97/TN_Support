package com.tnsupport.services.MainService.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tnsupport.dtos.AttributeDTO;
import com.tnsupport.dtos.InnerDTO;
import com.tnsupport.model.SiteInfo;
import com.tnsupport.repository.impl.SiteInfoDAOImpl;
import com.tnsupport.services.MainService.IMainService;

@Service
public class MainServiceImpl implements IMainService {

	private static final Logger LOGGER = Logger.getLogger(SiteInfoDAOImpl.class.getName());
	
	@Autowired
	private SiteInfoDAOImpl siteDao;
	
	private AttributeDTO attDto = new AttributeDTO();
	
	public ResponseEntity<AttributeDTO> saveSite(InnerDTO innerDTO){
		long siteID = 0;
		try {
		siteDao.getSiteByID(innerDTO.getSiteID());
		//exception
		} catch (Exception e) {
			SiteInfo site = new SiteInfo();
			site.setSiteID(innerDTO.getSiteID());
			siteDao.saveSite(site);
			siteID = site.getSiteID();
			attDto.addAttribute(siteID);
		}
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}
}
