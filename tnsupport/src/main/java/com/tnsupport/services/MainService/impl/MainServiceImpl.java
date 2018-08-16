package com.tnsupport.services.MainService.impl;

import java.util.List;

//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tnsupport.dtos.AttributeDTO;
import com.tnsupport.dtos.InnerDTO;
import com.tnsupport.model.SiteInfo;
import com.tnsupport.repository.ISiteInfoDAO;
import com.tnsupport.services.MainService.IMainService;

@Service
public class MainServiceImpl implements IMainService {

//	private static final Logger LOGGER = Logger.getLogger(SiteInfoDAOImpl.class.getName());
	
	@Autowired
	private ISiteInfoDAO siteDao;
	
	private AttributeDTO attDto = new AttributeDTO();
	
	public void saveSite(InnerDTO innerDto){
		SiteInfo siteInfo = new SiteInfo();
		siteInfo.setSiteId(innerDto.getSiteId());
		siteDao.save(siteInfo);
	}
	
	
	public ResponseEntity<AttributeDTO> getSiteId(){
		List<SiteInfo> siteInfo=siteDao.findAll();
		attDto.addAttribute(siteInfo.get(0).getSiteId());
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}
	
}
