package com.tnsupport.services.RestTemplateService;

import java.util.List;

import com.tnsupport.model.Performer;
import com.tnsupport.model.SiteInfo;

public interface IRestTemplateService {

	public SiteInfo getSiteInfo();
	
	public List<Performer> getPerformers();
	
}
