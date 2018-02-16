package de.roocks.garagesale.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.CategoryEntity;
import de.roocks.garagesale.model.Category;

@Service
@Transactional
public class CategoryService {

	@PersistenceContext
	private EntityManager em;

	public Category getCategoryById(Long id) {
		CategoryEntity categoryEntity = em.find(CategoryEntity.class, id);
		return mapEntityToCategory(categoryEntity);
	}

	public void deleteCategoryById(Long id) {
		CategoryEntity categoryEntity = em.find(CategoryEntity.class, id);
		if (categoryEntity != null)		
			em.remove(categoryEntity);
	}

	public Long storeCategory(Category category) {
		CategoryEntity categoryEntity = new CategoryEntity(category);
		em.persist(categoryEntity);
		return categoryEntity.getId();
	}

	public Category mapEntityToCategory(CategoryEntity categoryEntity) {
		if (categoryEntity == null)
			return null;
		return new Category(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDescription());
	}
}
