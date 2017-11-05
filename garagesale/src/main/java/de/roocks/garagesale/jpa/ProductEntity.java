package de.roocks.garagesale.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	private BigDecimal price;
	private Long seller_id;
	private Long buyer_id;

//	@OneToMany(
//		mappedBy = "productEntity",
//		cascade = CascadeType.ALL,
//		orphanRemoval = true
//	)
//	List<FotoEntity> fotos = new ArrayList<FotoEntity>();
//	
//	public void addFoto(FotoEntity fotoEntity) {
//		fotos.add(fotoEntity);
//		fotoEntity.setProductEntity(this);
//	}
//	
//	public void removeFoto(FotoEntity fotoEntity) {
//		fotos.remove(fotoEntity);
//		fotoEntity.setProductEntity(null);
//	}
//	
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
