package de.roocks.garagesale.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import de.roocks.garagesale.model.Address;

@Entity
@Table (name ="address")
public class AddressEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "housenumber")
	private String housenumber;
	
	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "additionalinfo")
	private String additionalinfo;
	
	@ManyToMany(mappedBy = "addresses")
	List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
	
	public AddressEntity() {
		super();
	}
	
	public AddressEntity(Address address) {
		super();
		this.country = address.getCountry();
		this.city = address.getCity();
		this.street = address.getStreet();
		this.housenumber = address.getHousenumber();
		this.postcode = address.getPostcode();
		this.additionalinfo = address.getAdditionalinfo();
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
	
	public String getAdditionalInfo() {
		return additionalinfo;
	}
	
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalinfo = additionalInfo;
	}
}
