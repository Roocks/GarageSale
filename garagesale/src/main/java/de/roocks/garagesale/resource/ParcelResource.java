package de.roocks.garagesale.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import de.roocks.garagesale.model.Parcel;
import de.roocks.garagesale.service.ParcelService;

@Path("parcels")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParcelResource {
	
	@Autowired
	private ParcelService parcelService;
	
	@POST
	@Path("parcel")
	public void storeParcel(Parcel parcel) {
		parcelService.storeParcel(parcel);
	}
	
	@GET
	@Path("parcel") 
	public Parcel getParcelById(@QueryParam ("id") Long id) {
		return parcelService.getParcelById(id);
	}
	
	@DELETE
	@Path("parcel")
	public void deleteParcelById(@QueryParam ("id") Long id) {
		parcelService.deleteParcelById(id);
	}
}
