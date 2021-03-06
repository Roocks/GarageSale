package de.roocks.garagesale.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "parcel")
public class ParcelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "timestamp")
	private Date timestamp;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	@OneToMany(mappedBy = "parcelEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemEntity> items = new ArrayList<ItemEntity>();

	public ParcelEntity() {
		this.timestamp = new Date();
	}
	
	public void addItem(ItemEntity item) {
		items.add(item);
		item.setParcelEntity(this);
	}
	
	public void removeItem(ItemEntity item) {
		items.remove(item);
		item.setParcelEntity(null);
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

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}
}
