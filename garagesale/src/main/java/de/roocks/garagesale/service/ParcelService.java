package de.roocks.garagesale.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.CustomerEntity;
import de.roocks.garagesale.jpa.ItemEntity;
import de.roocks.garagesale.jpa.ParcelEntity;
import de.roocks.garagesale.model.Item;
import de.roocks.garagesale.model.Parcel;

@Service
@Transactional
public class ParcelService {

	@PersistenceContext
	private EntityManager em;

	public void storeParcel(Parcel parcel) {
		CustomerEntity customer = em.find(CustomerEntity.class, parcel.getCustomerId());
		if (customer != null) {
			
			ParcelEntity entity = new ParcelEntity();
			
//			for (Item i : parcel.getItems()) {
//				entity.addItem(em.find(ItemEntity.class, i.getId()));
//			}
			
			entity.setCustomer(customer);
			em.persist(entity);
		}
	}

	public Parcel getParcelById(Long id) {
		ParcelEntity entity = em.find(ParcelEntity.class, id);
		return convertEntityToParcel(entity);
	}

	private Parcel convertEntityToParcel(ParcelEntity entity) {
		
		ItemService is = new ItemService();
		List<Item> items = new ArrayList<Item>();
		
		for(ItemEntity e : entity.getItems()) {
			items.add(is.convertEntityToItem(e));
		}
		Parcel parcel = new Parcel(entity.getId(), entity.getTimestamp(), entity.getCustomer().getId(), items);
		return parcel;
	}

	public void deleteParcelById(Long id) {
		ParcelEntity entity = em.find(ParcelEntity.class, id);
		em.remove(entity);
	}
}
