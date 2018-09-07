package com.tnsupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsupport.model.Performer;

public interface IPerformerDAO extends JpaRepository<Performer, Long> {
	
	public Performer findByPerformerId(long performerId);
}
