package de.roocks.garagesale.model;

import lombok.Data;

@Data
public class Address {
	
	
	private Long id;
	private String country;
	private String city;
	private String street;
	private String housenumber;
	private String postcode;
	private String additionalinfo;
	
	public Address() {
		super();
	}

	public Address(Long id, String country, String city, String street, String housenumber, String postcode,
			String additionalinfo) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.street = street;
		this.housenumber = housenumber;
		this.postcode = postcode;
		this.additionalinfo = additionalinfo;
	}
}
