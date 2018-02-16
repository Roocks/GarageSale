package de.roocks.garagesale.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Product {
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Long sellerId;
	private List<Long> fotoIds;
	private Long buyerId;

	public Product() {
		super();
	}

	public Product(Long id, String name, String description, BigDecimal price, List<Long> fotoIds, Long sellerId,
			Long buyerId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.fotoIds = fotoIds;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
	}

	public Product(Long id, String name, String description, BigDecimal price, List<Long> fotoIds, Long sellerId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.fotoIds = fotoIds;
		this.sellerId = sellerId;
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

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public List<Long> getFotoIds() {
		return fotoIds;
	}

	public void setFotoIds(List<Long> fotoIds) {
		this.fotoIds = fotoIds;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
}
