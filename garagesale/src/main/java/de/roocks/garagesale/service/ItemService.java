package de.roocks.garagesale.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.ItemEntity;
import de.roocks.garagesale.jpa.ParcelEntity;
import de.roocks.garagesale.jpa.ProductEntity;
import de.roocks.garagesale.model.Item;

@Service
@Transactional
public class ItemService {

	@PersistenceContext
	private EntityManager em;

	public void storeItem(Item item) {
		ParcelEntity parcel = em.find(ParcelEntity.class, item.getParcelId());
		ProductEntity product = em.find(ProductEntity.class, item.getProductId());
		if (parcel != null && product != null) {
			ItemEntity entity = new ItemEntity();
			entity.setAmount(item.getAmount());
			entity.setParcelEntity(parcel);
			entity.setProductEntity(product);
			em.persist(entity);
		}
	}

	public Item getItemById(Long id) {
		ItemEntity entity = em.find(ItemEntity.class, id);
		return convertEntityToItem(entity);
	}

	public void deleteItemById(Long id) {
		ItemEntity entity = em.find(ItemEntity.class, id);
		if (entity != null)
			em.remove(entity);
	}

	public Item convertEntityToItem(ItemEntity entity) {
		if (entity == null)
			return null;
		return new Item(entity.getId(), entity.getAmount(), entity.getParcelEntity().getId(),
				entity.getProductEntity().getId());
	}
}
