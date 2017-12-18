package de.roocks.garagesale.model;

import java.util.List;

import lombok.Data;

@Data
public class Customer {

	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String secondname;
	private String email;
	private Address mainaddress;
	private List<Address> addresses;
	private List<Long> parcelIds;

	public Customer() {
		super();
	}
	
	public Customer(Long id, String username, String password, String firstname, String secondname, String email, Address mainaddress, List<Address> addresses, List<Long> parcelIds) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.secondname = secondname;
		this.email = email;
		this.mainaddress = mainaddress;
		this.addresses = addresses;
		this.parcelIds =parcelIds;
	}
}
