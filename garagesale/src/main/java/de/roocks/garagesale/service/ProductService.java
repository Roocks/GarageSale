package de.roocks.garagesale.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.exception.EntityNotFoundException;
import de.roocks.garagesale.jpa.CustomerEntity;
import de.roocks.garagesale.jpa.FotoEntity;
import de.roocks.garagesale.jpa.ProductEntity;
import de.roocks.garagesale.model.Product;

@Service
@Transactional
public class ProductService {

	@PersistenceContext
	private EntityManager em;

	public Long storeProduct(Product product) {

		CustomerEntity customerEntity = em.find(CustomerEntity.class, product.getSellerId());
		if (customerEntity == null)
			throw new EntityNotFoundException("Product can not be saved. Customer by id = " + product.getSellerId() + " not found");
		ProductEntity productEntity = new ProductEntity(product);
		productEntity.setSeller(customerEntity);
		em.persist(productEntity);
		return productEntity.getId();
	}

	public Product getProductById(Long id) {
		ProductEntity productEntity = em.find(ProductEntity.class, id);
		return maptEntityToProduct(productEntity);
	}

	public void deleteProductById(Long id) {
		ProductEntity productEntity = em.find(ProductEntity.class, id);
		if (productEntity != null)
			em.remove(productEntity);
	}
	
	public Product maptEntityToProduct(ProductEntity productEntity) {
		if (productEntity == null)
			return null;
		CustomerEntity buyer = productEntity.getBuyer();
		List<Long> fotosIds = new ArrayList<Long>();
		for (FotoEntity fotoEntity : productEntity.getFotos()) {
			fotosIds.add(fotoEntity.getId());
		}

		if (buyer != null)
			return new Product(productEntity.getId(), productEntity.getName(), productEntity.getDescription(), productEntity.getPrice(), fotosIds,
					productEntity.getSeller().getId(), buyer.getId());
		return new Product(productEntity.getId(), productEntity.getName(), productEntity.getDescription(), productEntity.getPrice(), fotosIds,
				productEntity.getSeller().getId());
	}

}
