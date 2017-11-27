package de.roocks.garagesale.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.roocks.garagesale.model.Item;

@Entity
@Table (name = "parcel_item")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "amount")
	private int amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parcel_id")
	private ParcelEntity parcelEntity;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;
	
	public ItemEntity() {
		super();
	}
	
	public ItemEntity(Item item) {
		super();
		this.amount = item.getAmount();
	}
	
	// getters/setters
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

	public ParcelEntity getParcelEntity() {
		return parcelEntity;
	}

	public void setParcelEntity(ParcelEntity parcelEntity) {
		this.parcelEntity = parcelEntity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
}
