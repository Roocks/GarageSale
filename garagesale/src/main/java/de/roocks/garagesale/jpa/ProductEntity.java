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

import de.roocks.garagesale.model.Product;

@Entity
@Table(name = "product")
@NamedQueries({ @NamedQuery(name = ProductEntity.QUERY_GET_ALL, query = "SELECT c FROM ProductEntity c") })
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productEntity")
	List<FotoEntity> fotos = new ArrayList<FotoEntity>();

	public static final String QUERY_GET_ALL = "ProductEntity.findAll";

	public static TypedQuery<ProductEntity> GET_ALL(EntityManager em) {
		TypedQuery<ProductEntity> query = em.createNamedQuery(QUERY_GET_ALL, ProductEntity.class);
		return query;
	}

	public ProductEntity() {
		super();
	}

	public ProductEntity(Product product) {
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();

	}

	public void addFoto(FotoEntity fotoEntity) {
		fotos.add(fotoEntity);
		fotoEntity.setProductEntity(this);
	}

	public void removeFoto(FotoEntity fotoEntity) {
		fotos.remove(fotoEntity);
		fotoEntity.setProductEntity(null);
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

	public CustomerEntity getSeller() {
		return seller;
	}

	public void setSeller(CustomerEntity seller) {
		this.seller = seller;
	}

	public CustomerEntity getBuyer() {
		return buyer;
	}

	public void setBuyer(CustomerEntity buyer) {
		this.buyer = buyer;
	}

	public List<FotoEntity> getFotos() {
		return fotos;
	}

	public void setFotos(List<FotoEntity> fotos) {
		this.fotos = fotos;
	}
}
