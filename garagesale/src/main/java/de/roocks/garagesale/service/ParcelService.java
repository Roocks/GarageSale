package de.roocks.garagesale.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private ItemService itemService;

	public Long storeParcel(Parcel parcel) {
		CustomerEntity customerEntity = em.find(CustomerEntity.class, parcel.getCustomerId());
		if (customerEntity == null)
			return null;
		ParcelEntity parcelEntity = new ParcelEntity();
		parcelEntity.setCustomer(customerEntity);
		em.persist(parcelEntity);
		return parcelEntity.getId();
	}

	public Parcel getParcelById(Long id) {
		ParcelEntity parcelEntity = em.find(ParcelEntity.class, id);
		return mapEntityToParcel(parcelEntity);
	}

	public void deleteParcelById(Long id) {
		ParcelEntity parcelEntity = em.find(ParcelEntity.class, id);
		em.remove(parcelEntity);
	}
	
	private Parcel mapEntityToParcel(ParcelEntity parcelEntity) {		
		List<Item> items = new ArrayList<Item>();
		for (ItemEntity itemEntity : parcelEntity.getItems()) {
			items.add(itemService.mapEntityToItem(itemEntity));
		}
		Parcel parcel = new Parcel(parcelEntity.getId(), parcelEntity.getTimestamp(), parcelEntity.getCustomer().getId(), items);
		return parcel;
	}
}
