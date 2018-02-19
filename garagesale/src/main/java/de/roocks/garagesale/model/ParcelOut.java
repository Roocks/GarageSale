package de.roocks.garagesale.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParcelOut {
	
	private Long id;
	private Date timestamp;
	private Link customer;
	private List<ItemOut> items = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Link getCustomer() {
		return customer;
	}
	public void setCustomer(Link customer) {
		this.customer = customer;
	}
	public List<ItemOut> getItems() {
		return items;
	}
	public void setItems(List<ItemOut> items) {
		this.items = items;
	}
	
}
