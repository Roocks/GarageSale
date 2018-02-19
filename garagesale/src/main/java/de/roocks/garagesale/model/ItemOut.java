package de.roocks.garagesale.model;

public class ItemOut {
	
	private Long id;	
	private int amount;
	private Link productId;
	
	public ItemOut() {
		super();
	}
	
	public ItemOut(Long id, int amount, Link productId) {
		super();
		this.id = id;
		this.amount = amount;
		this.productId = productId;
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

	public Link getProductId() {
		return productId;
	}

	public void setProductId(Link productId) {
		this.productId = productId;
	}
}
