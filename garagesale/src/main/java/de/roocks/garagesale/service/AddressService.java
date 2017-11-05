package de.roocks.garagesale.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.AddressEntity;
import de.roocks.garagesale.model.Address;

@Service
@Transactional
public class AddressService {
	
	@PersistenceContext
	private EntityManager em;
	
	public void storeAddress(Address address) {
		AddressEntity entity = new AddressEntity(address);
		em.persist(entity);
	}
}
