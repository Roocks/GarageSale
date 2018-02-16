package de.roocks.garagesale.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Customer {

	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String secondname;
	private String email;
	private Address address;
	@JsonIgnore
	private List<Long> parcelIds;

	public Customer() {
		super();
	}

	public Customer(Long id, String username, String password, String firstname, String secondname, String email, Address address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.secondname = secondname;
		this.email = email;
		this.address = address;
	}

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Long> getParcelIds() {
		return parcelIds;
	}

	public void setParcelIds(List<Long> parcelIds) {
		this.parcelIds = parcelIds;
	}
}
