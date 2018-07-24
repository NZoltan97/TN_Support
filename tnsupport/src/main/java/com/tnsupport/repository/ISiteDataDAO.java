package com.tnsupport.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsupport.model.SiteData;

@Transactional
public interface ISiteDataDAO extends JpaRepository<SiteData, Long> {
	
	public SiteData findSiteByID(long id);
}
