package de.roocks.garagesale.model;

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

	public Address(String country, String city, String street, String housenumber, String postcode,
			String additionalinfo) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.housenumber = housenumber;
		this.postcode = postcode;
		this.additionalinfo = additionalinfo;
	}
	
	// getters/setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAdditionalinfo() {
		return additionalinfo;
	}

	public void setAdditionalinfo(String additionalinfo) {
		this.additionalinfo = additionalinfo;
	}	
}
