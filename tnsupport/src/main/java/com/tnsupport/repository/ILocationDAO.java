package com.tnsupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsupport.model.Location;

public interface ILocationDAO extends JpaRepository<Location,Long> {
	
	public Location findByLocationId(long locationId);
}
