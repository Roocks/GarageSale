package de.roocks.garagesale.model;

import java.math.BigDecimal;

public class Product {
	
	private Long id;	
	private String name;
	private String description;
	private BigDecimal price;
	private Long seller_id;
	private Long buyer_id;
	
	public Product() {
		super();
	}
	
	public Product(Long id, String name, String description, BigDecimal price, Long seller_id, Long buyer_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.seller_id = seller_id;
		this.buyer_id = buyer_id;
		
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Long seller_id) {
		this.seller_id = seller_id;
	}
	public Long getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(Long buyer_id) {
		this.buyer_id = buyer_id;
	}

}
