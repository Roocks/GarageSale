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
		CategoryEntity entity = em.find(CategoryEntity.class, id);
		return convertEntityToCategory(entity);
	}

	public void deleteCategoryById(Long id) {
		CategoryEntity entity = em.find(CategoryEntity.class, id);
		if (entity != null)
			em.remove(entity);
	}

	public void storeCategory(Category category) {
		CategoryEntity entity = new CategoryEntity(category);
		em.persist(entity);
	}

	public Category convertEntityToCategory(CategoryEntity entity) {
		if (entity == null)
			return null;
		return new Category(entity.getId(), entity.getName(), entity.getDescription());
	}
}
