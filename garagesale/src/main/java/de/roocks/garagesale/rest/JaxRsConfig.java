package de.roocks.garagesale.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JaxRsConfig extends ResourceConfig {

	public  JaxRsConfig() {
		packages("de.roocks.garagesale.resource");
	}	
}