package de.roocks.garagesale.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import de.roocks.garagesale.model.Category;

@Entity
@Table(name = "category")
@NamedQueries({ @NamedQuery(name = CategoryEntity.QUERY_GET_ALL, query = "SELECT c FROM CategoryEntity c") })
public class CategoryEntity {

	public static final String QUERY_GET_ALL = "CategoryEntity.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	public CategoryEntity() {
		super();
	}

	public CategoryEntity(Category category) {
		super();
		this.name = category.getName();
		this.description = category.getDescription();
	}

	public static TypedQuery<CategoryEntity> GET_ALL(EntityManager em) {
		TypedQuery<CategoryEntity> query = em.createQuery(QUERY_GET_ALL, CategoryEntity.class);
		return query;
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
}
