package de.roocks.garagesale.model;

import java.util.Date;

public class Parcel {
	
	private Long id;
	private Date timestamp;
	private Long customer_id;
	
	public Parcel() {
		super();
	}
	
	public Parcel(Long id, Date timestamp, Long customer_id) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.customer_id = customer_id;
	}

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
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
}
