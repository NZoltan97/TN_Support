package com.tnsupport.beans;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
	
	@Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
          new ConcurrentMapCache("siteInfos"), 
          new ConcurrentMapCache("performers"), 
          new ConcurrentMapCache("zones"),
          new ConcurrentMapCache("locations"), 
          new ConcurrentMapCache("tickets")));
        return cacheManager;
    }	
}
