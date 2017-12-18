package de.roocks.garagesale.model;

import lombok.Data;

@Data
public class Category {
	
	private Long id;
	private String name;
	private String description;
	
	public Category() {
		super();
	}

	public Category(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
}
