package de.roocks.garagesale.model;

import lombok.Data;

@Data
public class Item {
	
	private Long id;	
	private int amount;
	private Long parcelId;
	private Long productId;
	
	public Item() {
		super();
	}
	
	public Item(Long id, int amount, Long parcel_id, Long product_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.parcelId = parcel_id;
		this.productId = product_id;
	}
}
