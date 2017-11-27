package de.roocks.garagesale.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.roocks.garagesale.model.Customer;

@Entity
@Table(name ="customer")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "secondname")
	private String secondname;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne
	@JoinColumn(name = "mainaddress_id")
	private AddressEntity mainaddress;
	
	@ManyToMany
	@JoinTable (
			name = "customer_address",
			joinColumns = {@JoinColumn (name = "customer_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn (name = "address_id", referencedColumnName = "id")}
			)
	List<AddressEntity> addresses = new ArrayList<AddressEntity>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	List<ParcelEntity> parcels = new ArrayList<ParcelEntity>();
	
	public CustomerEntity() {
		super();
	}

	public CustomerEntity(Customer customer) {
		this.username = customer.getUsername();
		this.password = customer.getPassword();
		this.firstname = customer.getFirstname();
		this.secondname = customer.getSecondname();
		this.email = customer.getEmail();
	}

	// getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getSecondName() {
		return secondname;
	}

	public void setSecondName(String secondName) {
		this.secondname = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	public AddressEntity getMainaddress() {
		return mainaddress;
	}

	public void setMainaddress(AddressEntity mainaddress) {
		this.mainaddress = mainaddress;
	}

	public List<ParcelEntity> getParcels() {
		return parcels;
	}

	public void setParcels(List<ParcelEntity> parcels) {
		this.parcels = parcels;
	}
}
