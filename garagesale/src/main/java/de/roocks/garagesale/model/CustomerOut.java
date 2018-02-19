package de.roocks.garagesale.model;

public class CustomerOut {

	private Long id;
	private String firstname;
	private String secondname;
	private String email;
	private Link address;

	public CustomerOut() {
		super();
	}

	public CustomerOut(Customer customer) {
		this.id = customer.getId();
		this.firstname = customer.getFirstname();
		this.secondname = customer.getSecondname();
		this.email = customer.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Link getAddress() {
		return address;
	}

	public void setAddress(Link address) {
		this.address = address;
	}
}
