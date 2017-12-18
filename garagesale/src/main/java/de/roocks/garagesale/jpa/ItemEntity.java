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
import lombok.Data;

@Data
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
}
