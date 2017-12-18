package de.roocks.garagesale.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.CustomerEntity;
import de.roocks.garagesale.jpa.FotoEntity;
import de.roocks.garagesale.jpa.ProductEntity;
import de.roocks.garagesale.model.Product;

@Service
@Transactional
public class ProductService {

	@PersistenceContext
	private EntityManager em;

	public void storeProduct(Product product) {

		CustomerEntity seller = em.find(CustomerEntity.class, product.getSeller_id());
		if (seller == null)
			return;
		ProductEntity productEntity = new ProductEntity();
		productEntity.setPrice(product.getPrice());
		productEntity.setName(product.getName());
		productEntity.setDescription(product.getDescription());
		productEntity.setSeller(seller);
		for (Long id : product.getFotoIds()) {
			productEntity.addFoto(em.find(FotoEntity.class, id));
		}
		em.persist(productEntity);
	}

	public Product getProductById(Long id) {
		ProductEntity entity = em.find(ProductEntity.class, id);
		return convertEntityToProduct(entity);
	}

	public void deleteProductById(Long id) {
		ProductEntity entity = em.find(ProductEntity.class, id);
		if (entity != null)
			em.remove(entity);
	}

	public List<Product> getAllProducts() {
		TypedQuery<ProductEntity> query = ProductEntity.GET_ALL(em);
		List<Product> productList = new ArrayList<Product>();
		for (ProductEntity entity : query.getResultList()) {
			productList.add(convertEntityToProduct(entity));
		}
		return productList;
	}
	
	public Product convertEntityToProduct(ProductEntity entity) {
		if (entity == null)
			return null;
		CustomerEntity buyer = entity.getBuyer();
		List<Long> fotosIds = new ArrayList<Long>();
		for (FotoEntity fotoEntity : entity.getFotos()) {
			fotosIds.add(fotoEntity.getId());
		}

		if (buyer != null)
			return new Product(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), fotosIds,
					entity.getSeller().getId(), buyer.getId());
		return new Product(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), fotosIds,
				entity.getSeller().getId());
	}

}
