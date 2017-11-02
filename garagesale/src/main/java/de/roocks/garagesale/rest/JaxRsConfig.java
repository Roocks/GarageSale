package de.roocks.garagesale.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import de.roocks.garagesale.resource.CustomerResource;

@Component
public class JaxRsConfig extends ResourceConfig {

	public  JaxRsConfig() {
		packages("de.roocks.garagesale.resource");
	}	
}
