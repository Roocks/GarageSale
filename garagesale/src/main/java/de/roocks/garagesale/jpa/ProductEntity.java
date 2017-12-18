package de.roocks.garagesale.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import lombok.Data;

@Data
@Entity
@Table (name = "product")
@NamedQueries({
	@NamedQuery(name = ProductEntity.QUERY_GET_ALL, query = "SELECT c FROM ProductEntity c") 
})
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
	
	public static final String QUERY_GET_ALL = "ProductEntity.findAll";
	public static TypedQuery<ProductEntity> GET_ALL (EntityManager em){
		TypedQuery<ProductEntity> query = em.createNamedQuery(QUERY_GET_ALL, ProductEntity.class);
		return query;	
	}
	
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
}
