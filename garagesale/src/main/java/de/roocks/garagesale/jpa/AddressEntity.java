package de.roocks.garagesale.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import de.roocks.garagesale.model.Address;
import lombok.Data;


@Data
@Entity
@Table (name ="address")
@NamedQueries ({
	@NamedQuery (name = AddressEntity.QUERY_GET_ALL, query = "SELECT c FROM AddressEntity c")
	
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
	
	@ManyToMany(mappedBy = "addresses")
	List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
	
	public static final String QUERY_GET_ALL = "AddressEntity.findAll";
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
}
