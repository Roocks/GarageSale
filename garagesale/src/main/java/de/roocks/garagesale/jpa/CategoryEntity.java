package de.roocks.garagesale.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import de.roocks.garagesale.model.Category;
import lombok.Data;

@Entity
@Table (name = "category")
@Data
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column (name = "name")
	private String name;
	@Column (name = "description")
	private String description;
	
	public CategoryEntity() {
		super();
	}
	
	public CategoryEntity(Category category) {
		super();
		this.name = category.getName();
		this.description = category.getDescription();
	}
}
