package de.roocks.garagesale.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class Product {
	
	private Long id;	
	private String name;
	private String description;
	private BigDecimal price;
	private Long seller_id;
	private List<Long> fotoIds;
	private Long buyer_id;
	
	public Product() {
		super();
	}
	
	public Product(Long id, String name, String description, BigDecimal price, List<Long> fotoIds, Long seller_id, Long buyer_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.fotoIds = fotoIds;
		this.seller_id = seller_id;
		this.buyer_id = buyer_id;
	}

	public Product(Long id, String name, String description, BigDecimal price, List<Long> fotoIds, Long seller_id) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.fotoIds = fotoIds;
		this.seller_id = seller_id;
	}
}
