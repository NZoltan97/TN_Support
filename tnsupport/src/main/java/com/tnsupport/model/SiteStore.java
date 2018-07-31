package com.tnsupport.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data 
public class SiteStore {

	private Map<Long, Object> siteStore;
	
	public SiteStore() {
		siteStore = Collections.synchronizedMap(new HashMap<Long, Object>());
	}
	
}
