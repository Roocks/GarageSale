package de.roocks.garagesale.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@OneToOne
	@JoinColumn(name = "seller_id")
	private CustomerEntity seller;
	
	@OneToOne
	@JoinColumn(name = "buyer_id")
	private CustomerEntity buyer;

	@OneToMany (cascade = CascadeType.ALL, mappedBy = "productEntity")
	List<FotoEntity> fotos = new ArrayList<FotoEntity>();
	
	public ProductEntity() {
		super();
	}

	public void addFoto(FotoEntity fotoEntity) {
		fotos.add(fotoEntity);
		fotoEntity.setProductEntity(this);
	}
	
	public void removeFoto(FotoEntity fotoEntity) {
		fotos.remove(fotoEntity);
		fotoEntity.setProductEntity(null);
	}
	
	// getters/setters
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

	public CustomerEntity getSeller() {
		return seller;
	}

	public void setSeller(CustomerEntity seller) {
		this.seller = seller;
	}

	public CustomerEntity getBuyerId() {
		return buyer;
	}

	public void setBuyer_id(CustomerEntity buyerId) {
		this.buyer = buyerId;
	}

	public List<FotoEntity> getFotos() {
		return fotos;
	}

	public void setFotos(List<FotoEntity> fotos) {
		this.fotos = fotos;
	}
}
