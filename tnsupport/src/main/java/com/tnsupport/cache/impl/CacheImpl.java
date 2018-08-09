package com.tnsupport.cache.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.tnsupport.model.SiteStore;



public class CacheImpl {
	
	//Darab alapú cache vagy idő alapú?
	private final static int CACHE_SIZE=10;
	private Map<Long,SiteStore> synchronizedCacheMap;
	
	public CacheImpl() {
		synchronizedCacheMap=Collections.synchronizedMap(new HashMap<Long,SiteStore>());
	}
	
	public Map<Long, SiteStore> getCacheContent(){
		return synchronizedCacheMap;
	}
	
	public void addItem(Long id, SiteStore site) {
		if(synchronizedCacheMap.size()<CACHE_SIZE) {
			synchronizedCacheMap.put(id, site);
		}else {
			
		}
	}
	
}
