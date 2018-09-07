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

	// private static final Logger LOGGER =
	// Logger.getLogger(SiteInfoDAOImpl.class.getName());

	@Autowired
	private ISiteInfoDAO siteDao;

	private AttributeDTO attDto = new AttributeDTO();

	public ResponseEntity<AttributeDTO> saveSite(InnerDTO innerDto) {
		SiteInfo siteInfo = new SiteInfo();
		siteInfo.setSiteId(innerDto.getSiteId());
		siteDao.save(siteInfo);
		attDto.addAttribute(siteInfo.getSiteId());
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public ResponseEntity<AttributeDTO> getSiteId() {
		List<SiteInfo> siteInfo = siteDao.findAll();
		attDto.addAttribute(siteInfo.get(0).getSiteId());
		return new ResponseEntity<AttributeDTO>(attDto, HttpStatus.OK);
	}

	public void setVisitedCount(InnerDTO innerDto) {
		SiteInfo siteInfo = siteDao.findBySiteId(innerDto.getSiteId());
		switch (innerDto.getVisitedId()) {
		case 1:
			siteInfo.setVisitedPerfCount(innerDto.getVisitedPerfCount());
			break;
		case 2:
			siteInfo.setVisitedZoneCount(innerDto.getVisitedZoneCount());
			break;
		case 3:
			siteInfo.setVisitedLocationCount(innerDto.getVisitedLocationCount());
			break;
		case 4:
			siteInfo.setVisitedTicketCount(innerDto.getVisitedTicketCount());
			break;
		}
		siteDao.save(siteInfo);
	}

	public int getVisitedCount(InnerDTO innerDto) {
		switch (innerDto.getVisitedId()) {
		case 1:
			return siteDao.findBySiteId(innerDto.getSiteId()).getVisitedPerfCount();
		case 2:
			return siteDao.findBySiteId(innerDto.getSiteId()).getVisitedZoneCount();
		case 3:
			return siteDao.findBySiteId(innerDto.getSiteId()).getVisitedLocationCount();
		case 4:
			return siteDao.findBySiteId(innerDto.getSiteId()).getVisitedTicketCount();
		default:
			// Error code?
			return 0;
		}
	}
	
	public void setLikes(InnerDTO innerDto) {
		SiteInfo siteInfo = siteDao.findBySiteId(innerDto.getSiteId());
		switch (innerDto.getVisitedId()) {
		case 1:
			siteInfo.setVisitedPerfCount(innerDto.getVisitedPerfCount());
			break;
		case 2:
			siteInfo.setVisitedZoneCount(innerDto.getVisitedZoneCount());
			break;
		case 3:
			siteInfo.setVisitedLocationCount(innerDto.getVisitedLocationCount());
			break;
		case 4:
			siteInfo.setVisitedTicketCount(innerDto.getVisitedTicketCount());
			break;
		}
		siteDao.save(siteInfo);
	}

	public int getLikes(InnerDTO innerDto) {
		switch (innerDto.getVisitedId()) {
		case 1:
			return siteDao.findBySiteId(innerDto.getSiteId()).getVisitedPerfCount();
		case 2:
			return siteDao.findBySiteId(innerDto.getSiteId()).getVisitedZoneCount();
		case 3:
			return siteDao.findBySiteId(innerDto.getSiteId()).getVisitedLocationCount();
		case 4:
			return siteDao.findBySiteId(innerDto.getSiteId()).getVisitedTicketCount();
		default:
			// Error code?
			return 0;
		}
	}
}
