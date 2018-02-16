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

	public Long storeItem(Item item) {
		
		ParcelEntity parcelEntity = em.find(ParcelEntity.class, item.getParcelId());
		ProductEntity productEntity = em.find(ProductEntity.class, item.getProductId());
		if (productEntity == null || parcelEntity == null)
			return null;	
		
		ItemEntity itemEntity = new ItemEntity(item, parcelEntity, productEntity);
		em.persist(itemEntity);
		return itemEntity.getId();
	}

	public Item getItemById(Long id) {
		ItemEntity itemEntity = em.find(ItemEntity.class, id);
		return mapEntityToItem(itemEntity);
	}

	public void deleteItemById(Long id) {
		ItemEntity itemEntity = em.find(ItemEntity.class, id);
		if (itemEntity != null)
			em.remove(itemEntity);
	}

	public Item mapEntityToItem(ItemEntity itemEntity) {
		if (itemEntity == null)
			return null;
		return new Item(itemEntity.getId(), itemEntity.getAmount(), itemEntity.getParcelEntity().getId(),
				itemEntity.getProductEntity().getId());
	}
}
