package com.tnsupport.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsupport.model.Zone;

@Transactional
public interface IZoneDAO extends JpaRepository<Zone,Long>{
	
	public Zone findByZoneId(long zoneId);

}
