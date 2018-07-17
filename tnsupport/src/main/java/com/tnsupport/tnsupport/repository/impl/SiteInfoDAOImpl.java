package com.tnsupport.tnsupport.repository.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsupport.tnsupport.model.SiteInfo;
import com.tnsupport.tnsupport.repository.ISiteInfoDAO;

@Service
public class SiteInfoDAOImpl {
	
	private static final Logger LOGGER = Logger.getLogger(SiteInfoDAOImpl.class.getName());
	
	@Autowired
	private ISiteInfoDAO siteDao;
	
	public SiteInfo getSiteByID(long id) throws Exception {
		SiteInfo site = siteDao.findBySiteID(id);
		if (site == null)
			throw new Exception();
		return site;
	}
	
	public void saveSite(SiteInfo site) {
		try {
			siteDao.save(site);
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.toString(), e);
		}
	}
}
