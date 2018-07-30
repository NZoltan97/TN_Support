package com.tnsupport.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsupport.model.SiteInfo;

@Transactional
public interface ISiteInfoDAO extends JpaRepository<SiteInfo, Long> {

}
