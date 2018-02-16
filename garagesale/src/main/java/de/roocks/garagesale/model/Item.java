package de.roocks.garagesale.model;

import javax.validation.constraints.NotNull;


public class Item {
	
	private Long id;	
	private int amount;
	@NotNull
	private Long parcelId;
	@NotNull
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Long getParcelId() {
		return parcelId;
	}

	public void setParcelId(Long parcelId) {
		this.parcelId = parcelId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
