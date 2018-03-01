package de.roocks.garagesale.model;

import java.util.Date;


public class Token {
	
	private Long id;
	private String value;
	private Date createdOn;	
	private Customer customer;
	
	public Token() {
		super();
		this.createdOn = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getCreatedDate() {
		return createdOn;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdOn = createdDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", value=" + value + ", createdDate=" + createdOn + ", customer=" + customer + "]";
	}
	
	
	
}
