package com.tnsupport.tnsupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsupport.tnsupport.model.SiteInfo;

public interface ISiteInfoDAO extends JpaRepository<SiteInfo, Long> {

	public SiteInfo findBySiteID(long id);
}
