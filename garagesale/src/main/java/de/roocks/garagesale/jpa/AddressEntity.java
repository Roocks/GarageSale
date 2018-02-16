package de.roocks.garagesale.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import de.roocks.garagesale.model.Address;


@Entity
@Table (name ="address")
@NamedQueries ({
	@NamedQuery (	name = AddressEntity.QUERY_GET_ALL, 
					query = "SELECT c FROM AddressEntity c"),
	@NamedQuery (	name = AddressEntity.QUERY_GET_ALL_BY_POSTCODE, 
					query = "SELECT x FROM AddressEntity x WHERE x.postcode =:postCode")	
})
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
	
	@OneToMany(mappedBy = "address")
	List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
	
	public static final String QUERY_GET_ALL = "AddressEntity.findAll";
	public static final String QUERY_GET_ALL_BY_POSTCODE = "AddressEntity.findAddressesByPostcode";	
	
	public static TypedQuery<AddressEntity> GET_ALL_BY_POSTCODE (EntityManager em, String postcode){
		TypedQuery<AddressEntity> query = em.createNamedQuery(QUERY_GET_ALL_BY_POSTCODE, AddressEntity.class)
				.setParameter("postCode", postcode);
		return query;
	}
	
	public static TypedQuery<AddressEntity> GET_ALL(EntityManager em){
		TypedQuery<AddressEntity> query = em.createNamedQuery(QUERY_GET_ALL, AddressEntity.class);
		return query;
	}
	
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

	public List<CustomerEntity> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerEntity> customers) {
		this.customers = customers;
	}
}
