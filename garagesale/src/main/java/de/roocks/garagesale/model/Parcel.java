package de.roocks.garagesale.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Parcel {
	
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date timestamp;
	private Long customerId;
	private List<Item> items;
	
	public Parcel() {
		super();
	}
	
	public Parcel(Long id, Date timestamp, Long customerId, List<Item> items) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.customerId = customerId;
		this.items = items;
	}
}
