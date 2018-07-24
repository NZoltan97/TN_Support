package com.tnsupport.repository.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsupport.model.SiteData;
import com.tnsupport.repository.ISiteDataDAO;

@Service
public class SiteDataDAOImpl {

	private static final Logger LOGGER = Logger.getLogger(SiteDataDAOImpl.class.getName());
	
	@Autowired
	private ISiteDataDAO siteDao;
	
	public SiteData findSiteByID(long id) throws Exception {
		SiteData site = siteDao.findSiteByID(id);
		if (site == null)
			throw new Exception();
		return site;
	}
	
	public void saveSite(SiteData site) {
		try {
			siteDao.save(site);
		} catch (Exception e) {
			LOGGER.log(Level.ALL, e.toString(), e);
		}
	}
	
}
